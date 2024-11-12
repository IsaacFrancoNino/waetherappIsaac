package com.cincinnatiai.common

import com.cincinnatiai.common.model.Holiday

interface HolidayDataSource {
    suspend fun fetchHolidays(year: String): List<Holiday>

}