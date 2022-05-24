package com.buaja.ktorclientonandroidexample.domain.usecase

import com.buaja.ktorclientonandroidexample.domain.model.Cat
import com.buaja.ktorclientonandroidexample.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

@Factory
class GetCatUseCaseImpl(
    private val catRepository: CatRepository
): GetCatUseCase {
    override fun invoke(): Flow<Cat> {
        return catRepository.getCat()
    }
}