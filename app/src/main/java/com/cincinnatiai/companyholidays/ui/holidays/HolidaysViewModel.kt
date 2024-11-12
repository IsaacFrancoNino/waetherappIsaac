package com.cincinnatiai.companyholidays.ui.holidays

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cincinnatiai.common.HolidayDataSource
import com.cincinnatiai.common.model.Holiday
import kotlinx.coroutines.launch

interface HolidaysUILogic{
    val state: LiveData<HolidaysUiState>
    fun fetchHolidays()
}

class HolidaysViewModel(
    private val holidayDataSource: HolidayDataSource
): ViewModel(), HolidaysUILogic {

    private val _state = MutableLiveData<HolidaysUiState>(HolidaysUiState.Loading)
    override val state: LiveData<HolidaysUiState> = _state

    override fun fetchHolidays(){
        viewModelScope.launch { //lives in the context that you leave it
            _state.postValue(HolidaysUiState.Loading)
            try {
                val results = holidayDataSource.fetchHolidays("2024")
                _state.postValue(HolidaysUiState.Success(results))
            }catch (e: Throwable){
                _state.postValue(HolidaysUiState.Error)
            }
        }

    }

}

sealed class HolidaysUiState{
    object Loading : HolidaysUiState()
    data class Success (val holidays: List<Holiday>): HolidaysUiState()
    object Error : HolidaysUiState()

}