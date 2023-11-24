package com.nabilla.myquranapp.presentation.adzan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nabilla.myquranapp.network.Resource
import com.nabilla.myquranapp.network.adzan.AdzanDataResult
import com.nabilla.myquranapp.network.adzan.AdzanRepository

class AdzanViewModel (
    private val adzanRepository: AdzanRepository
) : ViewModel() {
    fun getDailyAdzanTime():
            LiveData<Resource<AdzanDataResult>> = adzanRepository
                .getResultDailyAdzanTime()
}