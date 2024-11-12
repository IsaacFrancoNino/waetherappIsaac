package com.cincinnatiai.companyholidays

import android.app.Application
import com.cincinnatiai.common.model.Holiday
import com.cincinnatiai.companyholidays.di.DIModule
import com.cincinnatiai.holidaylibrary.HolidayLibrary

class CompanyHolidaysApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        DIModule.initialize(HolidayLibrary.holidayDataSource)
    }
}