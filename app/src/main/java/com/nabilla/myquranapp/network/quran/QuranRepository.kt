package com.nabilla.myquranapp.network.quran

import com.nabilla.myquranapp.network.NetworkBoundResource
import com.nabilla.myquranapp.network.NetworkResponse
import com.nabilla.myquranapp.network.RemoteDataSource
import com.nabilla.myquranapp.network.Resource
import com.nabilla.myquranapp.utils.DataMapper
import kotlinx.coroutines.flow.Flow

class QuranRepository (private val remoteDataSource: RemoteDataSource) : IQuranRepository {
    override fun getListSurah(): Flow<Resource<List<Surah>>> {
        return object : NetworkBoundResource<List<Surah>, List<SurahItem>>() {
            override fun fetchFromNetwork(data: List<SurahItem>): Flow<List<Surah>> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<NetworkResponse<List<SurahItem>>> {
                return remoteDataSource.getListSurah()
            }
        }.asFlow()
    }

    override fun getDetailSurahWithQuranEditions(number: Int): Flow<Resource<List<QuranEdition>>> {
        return object : NetworkBoundResource<List<QuranEdition>, List<QuranEditionItem>>() {
            override fun fetchFromNetwork(data: List<QuranEditionItem>): Flow<List<QuranEdition>> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<NetworkResponse<List<QuranEditionItem>>> {
                return remoteDataSource.getDetailSurahWithQuranEditions(number)
            }
        }.asFlow()
    }
}