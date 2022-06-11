package com.example.challenge.model

import com.google.gson.annotations.SerializedName

data class ProductDetails (
    @SerializedName("id") var id:String?,
    @SerializedName("legal") var legal:String?,
    @SerializedName("images") var images: List<String>?
)
