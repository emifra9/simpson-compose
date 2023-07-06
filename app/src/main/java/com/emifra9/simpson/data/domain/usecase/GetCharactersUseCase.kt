package com.emifra9.simpson.data.domain.usecase

import com.emifra9.simpson.data.dto.CartoonList
import com.emifra9.simpson.data.repository.IRepository
import com.emifra9.simpson.utils.Resource

class GetCharactersUseCase (private val cellRepository: IRepository) {
    suspend operator fun invoke(): Resource<CartoonList> {
     return  cellRepository.getCharacters()
    }
}