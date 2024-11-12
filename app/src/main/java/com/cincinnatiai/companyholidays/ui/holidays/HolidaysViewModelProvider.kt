package com.cincinnatiai.companyholidays.ui.holidays

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cincinnatiai.companyholidays.di.DIModule

class HolidaysViewModelProvider: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HolidaysViewModel::class.java)){
            return HolidaysViewModel(DIModule.getInstance().holidayDataSource) as T
        }
        throw IllegalArgumentException("Must be of HolidaysViewModel")
    }
}