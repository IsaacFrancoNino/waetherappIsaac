package com.cincinnatiai.companyholidays.di

import android.provider.CalendarContract.Instances
import com.cincinnatiai.common.HolidayDataSource
import com.cincinnatiai.common.model.Holiday

class DIModule private constructor(
    val holidayDataSource: HolidayDataSource
){

    companion object{
        @Volatile
        private var INSTANCE: DIModule? = null

        @Synchronized
        fun initialize(holidayDataSource: HolidayDataSource){
            if (INSTANCE == null){
                synchronized(this){ //Block any other thread (Double locking)
                    if (INSTANCE == null){
                        INSTANCE = DIModule(holidayDataSource)
                    }
                }
            }
        }

        fun getInstance() = INSTANCE ?: throw IllegalArgumentException("Please call initialize again")
    }
}