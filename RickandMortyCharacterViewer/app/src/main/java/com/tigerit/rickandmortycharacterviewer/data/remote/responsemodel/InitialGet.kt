package com.tigerit.rickandmortycharacterviewer.data.remote.responsemodel

import com.google.gson.annotations.SerializedName

data class InitialGet(
    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val characters: List<Character>
)