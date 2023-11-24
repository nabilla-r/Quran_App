package com.nabilla.myquranapp.network.adzan

import com.nabilla.myquranapp.network.Resource

data class AdzanDataResult(
    val listLocation: List<String>,
    val dailyAdzan: Resource<DailyAdzan>,
    val listCalendar: List<String>
)
