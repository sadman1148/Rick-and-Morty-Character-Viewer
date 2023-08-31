package com.tigerit.rickandmortycharacterviewer.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.tigerit.rickandmortycharacterviewer.data.repository.remote.api.APIService
import com.tigerit.rickandmortycharacterviewer.data.repository.remote.api.APIUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAPIService(okHttpClient: OkHttpClient): APIService {
        return Retrofit.Builder()
            .baseUrl(APIUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(APIService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttp(context: Application) : OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .cache(Cache(context.cacheDir, (5 * 1024 * 1024).toLong()))
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (hasInternet(context))
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                chain.proceed(request)
            }
            .build()
        return okHttpClient
    }

    private fun hasInternet(context: Application): Boolean {

        // register activity with the connectivity manager service
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Returns a Network object corresponding to the currently active default data network
        val network = connectivityManager.activeNetwork ?: return false

        // Representation of the capabilities of an active network
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

        return when {
            // Indicates this network uses a Wi-Fi transport or WiFi has network connectivity
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true

            // Indicates this network uses a Cellular transport or Cellular has network connectivity
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

            // else return false
            else -> false
        }
    }
}