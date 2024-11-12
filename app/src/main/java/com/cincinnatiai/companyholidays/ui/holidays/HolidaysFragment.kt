package com.cincinnatiai.companyholidays.ui.holidays

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cincinnatiai.common.model.Holiday
import com.cincinnatiai.companyholidays.R
import com.cincinnatiai.companyholidays.databinding.FragmentHolidaysBinding
import com.cincinnatiai.companyholidays.utils.gone
import com.cincinnatiai.companyholidays.utils.show



class HolidaysFragment : Fragment(), HolidayAdapterListener {

    private var _binding: FragmentHolidaysBinding? = null
    private val binding get() = _binding!!
    private val holidaysUILogic: HolidaysUILogic by lazy {
        ViewModelProvider(requireActivity(),HolidaysViewModelProvider()) [HolidaysViewModel::class.java]
    }

    private var holidayAdapter : HolidayAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHolidaysBinding.inflate(inflater,container,false)
        holidayAdapter = HolidayAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = holidayAdapter
        holidaysUILogic.state.observe(viewLifecycleOwner){ state ->
            when(state){
                HolidaysUiState.Error -> handleError()
                HolidaysUiState.Loading -> showLoading()
                is HolidaysUiState.Success -> handleSuccess(state)
            }

        }
        holidaysUILogic.fetchHolidays()
        return binding.root
    }

    private fun handleError(){
        hideLoading()
        Toast.makeText(requireContext(),"Sorry, try again", Toast.LENGTH_LONG).show()
    }

    private fun handleSuccess(success: HolidaysUiState.Success){
        hideLoading()
        holidayAdapter?.setItems(success.holidays)
    }

    private fun showLoading(){
        binding.progressBar.show()
    }

    private fun hideLoading(){
        binding.progressBar.gone()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HolidaysFragment()
    }

    override fun onHolidayTapped(holiday: Holiday) {
        Toast.makeText(requireContext(),"You tapped on ${holiday.title}", Toast.LENGTH_LONG).show()
        val fragment = HolidayDetailsFragment()
        val bundle  = Bundle()
        bundle.putString("title", holiday.title)
        bundle.putString("start_date", holiday.startDate)
        bundle.putString("end_date", holiday.endDate)
        bundle.putString("id", holiday.id)
        bundle.putDouble("hours", holiday.hours)
        fragment.arguments = bundle
        val fragmentManager = (requireContext() as AppCompatActivity).supportFragmentManager
        val manager = fragmentManager.beginTransaction()
        manager.replace(R.id.frame_layout, fragment)
        manager.addToBackStack(null)
        manager.commit()
    }
}