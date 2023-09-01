package com.tigerit.rickandmortycharacterviewer.data.remote.api

import com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel.Episode
import com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel.InitialGet
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
    @GET(APIUrl.EXTENSION_URL_CHARACTER)
    suspend fun callApi(@Query("page") page: Int): InitialGet

    @GET
    suspend fun callEpisodeApi(@Url url: String): Episode
}