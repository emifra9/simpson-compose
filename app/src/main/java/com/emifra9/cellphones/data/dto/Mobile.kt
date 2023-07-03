package com.emifra9.cellphones.data.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Mobile (
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("brand")
    @Expose
    var brand: String,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("installmentsTag")
    @Expose
    var installmentsTag: String,
    @SerializedName("topTag")
    @Expose
    var topTag: String,
    @SerializedName("mainImage")
    @Expose
    var mainImage: MainImage,
    @SerializedName("images")
    @Expose
    var images: List<Images>,
    @SerializedName("legal")
    @Expose
    var legal: String
)

data class MainImage(
    @SerializedName("url")
    @Expose
    var url: String,
    @SerializedName("thumbnailUrl")
    @Expose
    var thumbnailUrl: String
)


data class Images(
    @SerializedName("url")
    @Expose
    var url: String,
    @SerializedName("thumbnailUrl")
    @Expose
    var thumbnailUrl: String
)