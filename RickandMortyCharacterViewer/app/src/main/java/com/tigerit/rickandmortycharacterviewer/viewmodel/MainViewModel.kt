package com.tigerit.rickandmortycharacterviewer.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tigerit.rickandmortycharacterviewer.data.Repository
import com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel.Episode
import com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel.InitialGet
import com.tigerit.rickandmortycharacterviewer.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val TAG = "MainViewModel"

    val characterListLiveData: LiveData<State<InitialGet>> get() = _characterListLiveData
    private val _characterListLiveData: MutableLiveData<State<InitialGet>> = MutableLiveData()

    val episodeListLiveData: LiveData<State<Episode>> get() = _episodeListLiveData
    private val _episodeListLiveData: MutableLiveData<State<Episode>> = MutableLiveData()

    fun getCharacters(pageNumber: Int) {
        Log.d(TAG, "getCharacters() >> Initial API called")
        viewModelScope.launch {
            repository.callApi(pageNumber).onEach {
                _characterListLiveData.value = it
            }.launchIn(viewModelScope)
        }
    }

    fun getEpisodes(list: List<String>) {
        Log.d(TAG, "getEpisodes() >> Episode API called")
        list.forEach { url ->
            viewModelScope.launch {
                repository.callEpisodeApi(url).onEach {
                    _episodeListLiveData.value = it
                }.launchIn(viewModelScope)
            }
        }
    }
}