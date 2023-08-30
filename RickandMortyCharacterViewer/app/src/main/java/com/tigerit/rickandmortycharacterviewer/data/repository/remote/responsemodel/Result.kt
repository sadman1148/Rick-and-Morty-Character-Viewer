package com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("origin")
    val origin: Origin,

    @SerializedName("location")
    val location: Location,

    @SerializedName("image")
    val image: String,

    @SerializedName("episode")
    val episode: ArrayList<String>,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String
)