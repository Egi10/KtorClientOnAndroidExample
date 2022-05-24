package com.buaja.ktorclientonandroidexample.domain.usecase

import com.buaja.ktorclientonandroidexample.domain.model.Cat
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

interface GetCatUseCase {
    operator fun invoke(): Flow<Cat>
}