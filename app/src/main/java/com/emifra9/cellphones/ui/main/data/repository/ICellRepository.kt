package com.emifra9.cellphones.ui.main.data.repository

import com.emifra9.cellphones.ui.main.data.dto.Mobile
import com.emifra9.cellphones.ui.main.utils.Resource

interface ICellRepository {

    suspend fun getMobiles(): Resource<List<Mobile>>

    suspend fun getMobile(id:Int): Resource<Mobile>

}