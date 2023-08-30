package com.tigerit.rickandmortycharacterviewer.data.repository

import com.tigerit.rickandmortycharacterviewer.data.repository.remote.api.APIService
import com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel.Get
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: APIService) {

    suspend fun getGet() : Get {
        return apiService.getGet()
    }

}