package com.tigerit.rickandmortycharacterviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tigerit.rickandmortycharacterviewer.data.repository.Repository
import com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel.Get
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val myGetResponse: MutableLiveData<Get> = MutableLiveData()

    fun getGet() {
        viewModelScope.launch {
            val getResponse = repository.getGet()
            myGetResponse.value = getResponse
        }
    }

}