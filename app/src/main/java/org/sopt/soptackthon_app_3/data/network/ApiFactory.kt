package org.sopt.soptackthon_app_3.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.sopt.soptackthon_app_3.data.service.BookingService
import org.sopt.soptackthon_app_3.data.service.ExampleService
import org.sopt.soptackthon_app_3.data.service.HelperDetailService
import org.sopt.soptackthon_app_3.data.service.UserInformationService
import retrofit2.Retrofit

object ApiFactory {
    private val BASE_URL: String = "http://3.35.37.190:8080"
    private val json = Json {
        ignoreUnknownKeys = true
    }
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val userinformationService=ApiFactory.create<UserInformationService>()

    val exampleService = ApiFactory.create<ExampleService>()
    val bookingService = ApiFactory.create<BookingService>()
    val helperDetailService = ApiFactory.create<HelperDetailService>()
}
