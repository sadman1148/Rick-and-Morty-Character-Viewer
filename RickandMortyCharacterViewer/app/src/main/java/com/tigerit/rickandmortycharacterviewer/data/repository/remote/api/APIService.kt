package com.tigerit.rickandmortycharacterviewer.data.repository.remote.api

import com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel.InitialGet
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET(APIUrl.EXTENSION_URL)
    suspend fun callApi(@Query("page") page:Int): InitialGet
}