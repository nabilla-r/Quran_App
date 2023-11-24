package com.nabilla.myquranapp.network.di

import android.content.Context
import com.nabilla.myquranapp.local.CalendarPreferences
import com.nabilla.myquranapp.local.LocationPreferences
import com.nabilla.myquranapp.network.ApiConfig
import com.nabilla.myquranapp.network.RemoteDataSource
import com.nabilla.myquranapp.network.adzan.AdzanRepository
import com.nabilla.myquranapp.network.quran.QuranRepository

object Injection {
    private val quranApiService = ApiConfig.getQuranService
    private val adzanApiService = ApiConfig.getAdzanTimeService
    private val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)
    fun provideQuranRepository(): QuranRepository {
        return QuranRepository(remoteDataSource)
    }

    fun provideAdzanRepository(context: Context): AdzanRepository {
        val locationPreferences = LocationPreferences(context)
        val calendarPreferences = CalendarPreferences()
        return AdzanRepository(remoteDataSource, locationPreferences, calendarPreferences )
    }
}