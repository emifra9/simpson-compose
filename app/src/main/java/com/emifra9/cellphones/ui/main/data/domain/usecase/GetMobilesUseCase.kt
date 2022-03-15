package com.emifra9.cellphones.ui.main.data.domain.usecase

import com.emifra9.cellphones.ui.main.data.dto.Mobile
import com.emifra9.cellphones.ui.main.data.repository.ICellRepository
import com.emifra9.cellphones.ui.main.utils.Resource
import retrofit2.Response

class GetMobilesUseCase (private val cellRepository: ICellRepository) {
    suspend operator fun invoke(): Resource<List<Mobile>> {
     return  cellRepository.getMobiles()
    }
}