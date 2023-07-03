package com.emifra9.cellphones.data.domain.usecase

import com.emifra9.cellphones.data.dto.Mobile
import com.emifra9.cellphones.data.repository.ICellRepository
import com.emifra9.cellphones.utils.Resource

class GetMobilesUseCase (private val cellRepository: ICellRepository) {
    suspend operator fun invoke(): Resource<List<Mobile>> {
     return  cellRepository.getMobiles()
    }
}