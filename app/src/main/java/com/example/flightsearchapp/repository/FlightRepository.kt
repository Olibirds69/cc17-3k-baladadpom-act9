package com.example.flightsearchapp.repository


import com.example.flightsearchapp.data.Airport
import com.example.flightsearchapp.data.FlightDao
import kotlinx.coroutines.flow.Flow

class FlightRepository(private val airportDao: FlightDao) {
    fun searchAirports(query: String): Flow<List<Airport>> {
        return airportDao.getAirportsBySearchQuery("%${query}%")
    }

    fun getDestinationAirports(departureCode: String): Flow<List<Airport>> {
        return airportDao.getAllAirportsExcept(departureCode)
    }

    suspend fun getAirportByCode(code: String): Airport? {
        return airportDao.getAirportByCode(code)
    }
}
