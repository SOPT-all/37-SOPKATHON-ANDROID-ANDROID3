package org.sopt.soptackthon_app_3.data.service


import org.sopt.soptackthon_app_3.data.dto.request.BookingRequest
import org.sopt.soptackthon_app_3.data.dto.response.BookingResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface BookingService {
    @POST("api/bookings")
    suspend fun createBooking(
        @Body request: BookingRequest
    ): BookingResponse
}