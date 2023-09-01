package com.tigerit.rickandmortycharacterviewer.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel.Character
import com.tigerit.rickandmortycharacterviewer.databinding.FragmentHomeBinding
import com.tigerit.rickandmortycharacterviewer.ui.RecyclerViewAdapter
import com.tigerit.rickandmortycharacterviewer.utils.State
import com.tigerit.rickandmortycharacterviewer.utils.Utility
import com.tigerit.rickandmortycharacterviewer.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var pageNumber = 1
    private var totalPages = 0
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
                    binding.loader.visibility = View.VISIBLE
                    Log.d(TAG, "onCreate() >> loading...")
                }

                is State.Success -> {
                    isLoading = false
                    binding.loader.visibility = View.GONE
                    totalPages = it.data.info.pages
                    recyclerViewAdapter.addItems(it.data.characters)
                }

                is State.Error -> {
                    Log.d(TAG, "onCreate() >> state error: " + it.exception.message)
                    if (!Utility.hasInternet(requireContext())) {
                        Utility.showNoInternetDialog(requireContext(), requireActivity())
                    }
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
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
        return binding.root
    }

}