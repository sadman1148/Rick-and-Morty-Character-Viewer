package com.tigerit.rickandmortycharacterviewer.data.repository.remote.responsemodel

import com.google.gson.annotations.SerializedName

data class Get(
    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: ArrayList<Result>
)