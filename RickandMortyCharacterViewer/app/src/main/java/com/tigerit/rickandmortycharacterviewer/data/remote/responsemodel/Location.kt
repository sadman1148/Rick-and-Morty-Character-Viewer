package com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)