package com.buaja.ktorclientonandroidexample.data.source

import com.buaja.ktorclientonandroidexample.data.source.response.CatResponseItem
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

/**
 * Created by Julsapargi Nursam on 5/24/22.
 * Mobile Engineer - Android
 */

/**
 * https://ktor.io/docs/request.html
 */

@Single
class RemoteDataSourceImpl(
    private val httpClient: HttpClient,
    @Named("IoDispatcher") private val ioDispatcher: CoroutineDispatcher
): RemoteDataSource {
    override fun getCat(): Flow<List<CatResponseItem>> {
        return flow {
            val response = httpClient.get(
                "https://api.thecatapi.com/v1/images/search?breed_ids=beng&include_breeds=true"
            ).body<List<CatResponseItem>>()

            emit(response)
        }.flowOn(ioDispatcher)
    }
}