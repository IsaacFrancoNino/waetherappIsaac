package com.cincinnatiai.companyholidays.ui.holidays

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cincinnatiai.common.model.Holiday
import com.cincinnatiai.companyholidays.R
import com.cincinnatiai.companyholidays.databinding.FragmentHolidayDetailsBinding

class HolidayDetailsFragment : Fragment() {
    private var _binding: FragmentHolidayDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHolidayDetailsBinding.inflate(inflater, container, false)
        val holiday = createHolidayItem()
        bindToView(holiday)
        return binding.root
    }

    private fun createHolidayItem(): Holiday {
        val title = arguments?.getString("title") ?: getString(R.string.no_title_string)
        val startDate = arguments?.getString("start_date") ?: getString(R.string.no_start_date_string)
        val endDate = arguments?.getString("end_date") ?: getString(R.string.no_end_date_string)
        val id = arguments?.getString("id") ?: getString(R.string.no_id_string)
        val hours = arguments?.getDouble("hours") ?: 0.0
        val holiday = Holiday(id, title, startDate, endDate, hours)
        return holiday
    }

    private fun bindToView(holiday: Holiday) {
        binding.holidayTitle.text = String.format("%s %s", getString(R.string.title_string), holiday.title)
        binding.holidayStartDate.text = String.format("%s %s", getString(R.string.start_date_string), holiday.startDate)
        binding.holidayEndDate.text = String.format("%s %s", getString(R.string.end_date_string), holiday.endDate)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HolidayDetailsFragment()
    }
}