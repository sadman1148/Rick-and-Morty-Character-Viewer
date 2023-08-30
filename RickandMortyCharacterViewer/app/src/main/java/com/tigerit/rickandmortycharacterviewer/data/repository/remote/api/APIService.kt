package com.tigerit.rickandmortycharacterviewer.data.repository.remote.api

import com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel.Get
import retrofit2.http.GET

interface APIService {
    @GET(APIUrl.EXTENSION_URL)
    suspend fun getGet(): Get
}