package com.emifra9.simpson.data.repository

import com.emifra9.simpson.data.dto.CartoonList
import com.emifra9.simpson.utils.Resource

interface IRepository {

    suspend fun getCharacters(): Resource<CartoonList>
}