package com.emifra9.cellphones.ui.main.data.domain.usecase

import com.emifra9.cellphones.ui.main.data.dto.Mobile
import com.emifra9.cellphones.ui.main.data.repository.ICellRepository
import com.emifra9.cellphones.ui.main.utils.Resource

class GetMobileUseCase (private val cellRepository: ICellRepository) {
    suspend operator fun invoke(id: Int): Resource<Mobile> {
       return cellRepository.getMobile(id)
    }
}