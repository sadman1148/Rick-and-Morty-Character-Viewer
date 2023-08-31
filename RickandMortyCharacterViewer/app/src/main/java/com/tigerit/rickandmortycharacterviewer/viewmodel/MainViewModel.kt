package com.tigerit.rickandmortycharacterviewer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tigerit.rickandmortycharacterviewer.data.repository.Repository
import com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel.Character
import com.tigerit.rickandmortycharacterviewer.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val characterListLiveData: LiveData<State<List<Character>>> get() = _characterListLiveData
    private val _characterListLiveData: MutableLiveData<State<List<Character>>> = MutableLiveData()

    fun getCharacters(pageNumber: Int) {
        viewModelScope.launch {
            repository.callApi(pageNumber).onEach {
                _characterListLiveData.value = it
            }.launchIn(viewModelScope)
        }
    }
}