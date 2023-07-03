package com.emifra9.cellphones.data.network

import com.emifra9.cellphones.data.dto.Mobile
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ICellService {

    @GET(CellConstants.pathGetMobiles)
    suspend fun getMobiles(): Response<List<Mobile>>

    @GET(CellConstants.pathGetMobiles + "/{id}" )
    suspend fun getMobile(  @Path("id") id:Int): Response<Mobile>


}