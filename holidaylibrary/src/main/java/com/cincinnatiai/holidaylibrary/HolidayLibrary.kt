package com.cincinnatiai.holidaylibrary

import com.cincinnatiai.common.HolidayDataSource
import com.cincinnatiai.holidaylibrary.repository.HolidayRepository

//Object = singleton
object HolidayLibrary {

    val holidayDataSource: HolidayDataSource by lazy {
        HolidayRepository()
    }
}