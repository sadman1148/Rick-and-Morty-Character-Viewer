package com.tigerit.rickandmortycharacterviewer.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel.Character
import com.tigerit.rickandmortycharacterviewer.databinding.FragmentHomeBinding
import com.tigerit.rickandmortycharacterviewer.ui.RecyclerViewAdapter
import com.tigerit.rickandmortycharacterviewer.utils.State
import com.tigerit.rickandmortycharacterviewer.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var pageNumber = 1
    private var totalPages = 2
    private var isLoading = false
    private val TAG = "HomeFragment"
    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val recyclerViewAdapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.getCharacters(pageNumber++)
        mainViewModel.characterListLiveData.observe(this) {
            when (it) {
                is State.Loading -> {
                    Log.d(TAG, "onCreate() >> loading...")
                }

                is State.Success -> {
                    isLoading = false
                    recyclerViewAdapter.addItems(it.data)
                }

                is State.Error -> {
                    Log.d(TAG, "onCreate() >> state error: " + it.exception.message)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = recyclerViewAdapter
        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1) && !isLoading && pageNumber <= totalPages) {
                    isLoading = true
                    mainViewModel.getCharacters(pageNumber++)
                }
            }
        })
    }

}