package com.cincinnatiai.companyholidays.ui.holidays

import androidx.recyclerview.widget.RecyclerView
import com.cincinnatiai.common.model.Holiday
import com.cincinnatiai.companyholidays.databinding.FragmentHolidaysBinding
import com.cincinnatiai.companyholidays.databinding.ItemHolidayBinding
//attach the data
class HolidayViewHolder(private val binding: ItemHolidayBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindModelToView(holiday: Holiday) {
        binding.holidayTitle.text = holiday.title
        binding.holidayDate.text = holiday.startDate
    }

}