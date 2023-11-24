package com.nabilla.myquranapp.network.quran

import com.nabilla.myquranapp.network.Resource
import kotlinx.coroutines.flow.Flow

interface IQuranRepository {
    fun getListSurah() : Flow<Resource<List<Surah>>>

    fun getDetailSurahWithQuranEditions(number: Int) : Flow<Resource<List<QuranEdition>>>
}