package com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel

import com.google.gson.annotations.SerializedName

data class Origin(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)