package com.buaja.ktorclientonandroidexample.data.source

import com.buaja.ktorclientonandroidexample.data.source.response.CatResponseItem
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

interface RemoteDataSource {
    fun getCat(): Flow<List<CatResponseItem>>
}