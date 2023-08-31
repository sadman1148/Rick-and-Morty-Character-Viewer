package com.tigerit.rickandmortycharacterviewer.data.repository

import com.tigerit.rickandmortycharacterviewer.data.repository.remote.api.APIService
import com.tigerit.rickandmortycharacterviewer.utils.State
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: APIService) {

    fun callApi(pageNumber: Int) = flow {
        emit(State.Loading)
        try {
            val result = apiService.callApi(pageNumber)
            emit(State.Success(result.characters))
        } catch (exception: Exception) {
            emit(State.Error(exception))
        }
    }
}