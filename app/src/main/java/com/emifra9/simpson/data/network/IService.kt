package com.emifra9.simpson.data.network

import com.emifra9.simpson.data.dto.CartoonList
import retrofit2.Response
import retrofit2.http.GET

interface IService {

    @GET(ApiConstants.pathGetCharacters)
    suspend fun getCharacters(): Response<CartoonList>


}