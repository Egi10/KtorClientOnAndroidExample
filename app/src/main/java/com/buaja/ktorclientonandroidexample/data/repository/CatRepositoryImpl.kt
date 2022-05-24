package com.buaja.ktorclientonandroidexample.data.repository

import com.buaja.ktorclientonandroidexample.data.source.RemoteDataSource
import com.buaja.ktorclientonandroidexample.domain.model.Cat
import com.buaja.ktorclientonandroidexample.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

@Single
class CatRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : CatRepository {
    override fun getCat(): Flow<Cat> {
        return remoteDataSource.getCat()
            .map {
                it.first()
            }.map {
                Cat(
                    url = it.url
                )
            }
    }
}