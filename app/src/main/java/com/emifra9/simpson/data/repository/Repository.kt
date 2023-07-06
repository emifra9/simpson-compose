package com.emifra9.simpson.data.repository

import com.emifra9.simpson.data.dto.CartoonList
import com.emifra9.simpson.data.network.IService
import com.emifra9.simpson.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val service: IService
): IRepository {
    override suspend fun getCharacters(): Resource<CartoonList> {
        Resource.loading( null)
        return try {
            val result = service.getCharacters()
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