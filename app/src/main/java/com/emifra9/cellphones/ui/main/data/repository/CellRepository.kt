package com.emifra9.cellphones.ui.main.data.repository

import com.emifra9.cellphones.ui.main.data.dto.Mobile
import com.emifra9.cellphones.ui.main.data.network.ICellService
import com.emifra9.cellphones.ui.main.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CellRepository @Inject constructor(
    private val cellService: ICellService
): ICellRepository {
    override suspend fun getMobiles(): Resource<List<Mobile>> {
        Resource.loading( null)
        return try {
            val result = cellService.getMobiles()
            if (result.isSuccessful) {
                return Resource.success(result.body()!!)
            }else{
                Resource.error("User not found", null)
            }
        } catch (e: Throwable) {
            Resource.error("Unknown Error", null)
        }
    }

    override suspend fun getMobile(id:Int): Resource<Mobile> {
        Resource.loading( null)
        return try {
            val result = cellService.getMobile(id)
            if (result.isSuccessful) {
                return Resource.success(result.body()!!)
            }else{
                Resource.error("User not found", null)
            }
        } catch (e: Throwable) {
            Resource.error("Unknown Error", null)
        }
    }
}