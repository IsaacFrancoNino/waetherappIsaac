package com.cincinnatiai.holidaylibrary.repository

import com.cincinnatiai.common.HolidayDataSource
import com.cincinnatiai.common.model.Holiday
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.UUID

class HolidayRepository(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO //thread you are working on
): HolidayDataSource {

    override suspend fun fetchHolidays(year: String): List<Holiday> = withContext(dispatcher) {
        delay(1200)
        return@withContext listOf(
            Holiday(id = UUID.randomUUID().toString(), "Daniel", "24-11-08", "24-11-08"),
            Holiday(id = UUID.randomUUID().toString(), "Hayali", "24-11-09", "24-11-09"),
            Holiday(id = UUID.randomUUID().toString(), "Isaac", "24-11-10", "24-11-10")
        )
    }

}