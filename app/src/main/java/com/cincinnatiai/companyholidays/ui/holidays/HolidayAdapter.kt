package com.cincinnatiai.companyholidays.ui.holidays

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cincinnatiai.common.model.Holiday
import com.cincinnatiai.companyholidays.databinding.ItemHolidayBinding

interface HolidayAdapterListener{
    fun onHolidayTapped(holiday: Holiday)
}

class HolidayAdapter(
    private  val adapterListener: HolidayAdapterListener
) : RecyclerView.Adapter<HolidayViewHolder>() {

    private val holidays = mutableListOf<Holiday>()

    fun setItems(holidays : List<Holiday>){
        this.holidays.addAll(holidays)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidayViewHolder {
        val binding = ItemHolidayBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HolidayViewHolder(binding)
    }

    override fun getItemCount(): Int = holidays.size

    override fun onBindViewHolder(holder: HolidayViewHolder, position: Int) {
        holder.bindModelToView(holidays[position])
        holder.itemView.setOnClickListener{
            adapterListener.onHolidayTapped(holidays[holder.adapterPosition])
        }
    }
}