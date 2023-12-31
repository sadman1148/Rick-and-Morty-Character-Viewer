package com.tigerit.rickandmortycharacterviewer.ui

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.Gson
import com.tigerit.rickandmortycharacterviewer.R
import com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel.Character
import com.tigerit.rickandmortycharacterviewer.databinding.RecyclerItemBinding

class RecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val characterList = mutableListOf<Character>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(characters: List<Character>) {
        characterList.addAll(characters)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character, context: Context) {
            binding.charName.text = character.name
            Glide
                .with(context)
                .load(Uri.parse(character.image))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(binding.charImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position], context)
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("data", Gson().toJson(characterList[position]))
            it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
    }

    override fun getItemCount() = characterList.size

}