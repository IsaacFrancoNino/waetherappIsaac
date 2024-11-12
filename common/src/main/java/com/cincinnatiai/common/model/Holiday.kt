package com.cincinnatiai.common.model

data class Holiday (
    val id: String,
    val title: String,
    val startDate: String,
    val endDate : String,
    val hours: Double = 8.0
)