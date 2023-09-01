package com.tigerit.rickandmortycharacterviewer.ui.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tigerit.rickandmortycharacterviewer.R
import com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel.Character
import com.tigerit.rickandmortycharacterviewer.databinding.FragmentDetailBinding
import com.tigerit.rickandmortycharacterviewer.utils.State
import com.tigerit.rickandmortycharacterviewer.utils.Utility
import com.tigerit.rickandmortycharacterviewer.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Type

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val TAG = "DetailFragment"
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding
    private lateinit var character: Character
    private var episodeList: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentDetailBinding.inflate(layoutInflater)
        character= getCharacter()
        mainViewModel.getEpisodes(character.episode)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding.apply {
            Glide.with(requireContext())
                .load(Uri.parse(character.image))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(charImg)
            charName.text = getString(R.string.char_name, character.name)
            charGender.text = getString(R.string.char_gender, character.gender)
            charLocation.text = getString(R.string.char_location, character.location.name)
            charOrigin.text = getString(R.string.char_origin, character.origin.name)
            charSpecies.text = getString(R.string.char_species, character.species)
            charStatus.text = getString(R.string.char_status, character.status)
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.episodeListLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is State.Loading -> {
                    binding.loader.visibility = View.VISIBLE
                    Log.d(TAG, "onCreate() >> loading...")
                }

                is State.Success -> {
                    binding.loader.visibility = View.GONE
                    episodeList += "Episode: ${it.data.episode} - ${it.data.name}\nAired on: ${it.data.airDate}\n\n"
                    binding.charEpisodes.text = episodeList
                }

                is State.Error -> {
                    Log.d(TAG, "onCreate() >> state error: " + it.exception.message)
                    Toast.makeText(requireContext(), "No internet, Cannot load episode list", Toast.LENGTH_SHORT).show()
                    binding.loader.visibility = View.GONE
                    binding.featuredHeader.visibility = View.GONE
                    binding.charEpisodes.visibility = View.GONE
                }
            }
        }
    }

    private fun getCharacter(): Character {
        val character: Type = object : TypeToken<Character>() {}.type
        return Gson().fromJson(arguments?.getString("data"), character)
    }

}