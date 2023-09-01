package com.tigerit.rickandmortycharacterviewer.data

import com.tigerit.rickandmortycharacterviewer.data.remote.api.APIService
import com.tigerit.rickandmortycharacterviewer.utils.State
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: APIService) {

    fun callApi(pageNumber: Int) = flow {
        emit(State.Loading)
        try {
            val result = apiService.callApi(pageNumber)
            emit(State.Success(result))
        } catch (exception: Exception) {
            emit(State.Error(exception))
        }
    }

    fun callEpisodeApi(url: String) = flow {
        emit(State.Loading)
        try {
            val result = apiService.callEpisodeApi(url)
            emit(State.Success(result))
        } catch (exception: Exception) {
            emit(State.Error(exception))
        }
    }
}