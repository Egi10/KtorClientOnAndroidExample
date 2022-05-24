package com.buaja.ktorclientonandroidexample.domain.repository

import com.buaja.ktorclientonandroidexample.domain.model.Cat
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

interface CatRepository {
    fun getCat(): Flow<Cat>
}