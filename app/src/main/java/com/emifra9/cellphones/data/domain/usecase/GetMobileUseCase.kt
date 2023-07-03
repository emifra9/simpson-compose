package com.emifra9.cellphones.data.domain.usecase

import com.emifra9.cellphones.data.dto.Mobile
import com.emifra9.cellphones.data.repository.ICellRepository
import com.emifra9.cellphones.utils.Resource

class GetMobileUseCase (private val cellRepository: ICellRepository) {
    suspend operator fun invoke(id: Int): Resource<Mobile> {
       return cellRepository.getMobile(id)
    }
}