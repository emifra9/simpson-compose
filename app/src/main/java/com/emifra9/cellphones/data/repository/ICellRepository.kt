package com.emifra9.cellphones.data.repository

import com.emifra9.cellphones.data.dto.Mobile
import com.emifra9.cellphones.utils.Resource

interface ICellRepository {

    suspend fun getMobiles(): Resource<List<Mobile>>

    suspend fun getMobile(id:Int): Resource<Mobile>

}