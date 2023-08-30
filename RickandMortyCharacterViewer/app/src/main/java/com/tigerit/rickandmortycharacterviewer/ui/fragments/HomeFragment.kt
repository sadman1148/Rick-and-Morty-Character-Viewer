package com.tigerit.rickandmortycharacterviewer.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tigerit.rickandmortycharacterviewer.R
import com.tigerit.rickandmortycharacterviewer.data.repository.Repository
import com.tigerit.rickandmortycharacterviewer.databinding.FragmentHomeBinding
import com.tigerit.rickandmortycharacterviewer.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        homeViewModel.getGet()
        homeViewModel.myGetResponse.observe(this, Observer {
            Log.d("response:", it.info.toString())
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

}