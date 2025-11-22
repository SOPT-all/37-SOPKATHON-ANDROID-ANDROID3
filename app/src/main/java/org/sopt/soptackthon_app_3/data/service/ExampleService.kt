package org.sopt.soptackthon_app_3.data.service

import org.sopt.soptackthon_app_3.data.dto.request.ExampleRequestDto
import org.sopt.soptackthon_app_3.data.dto.base.BaseResponse
import org.sopt.soptackthon_app_3.data.dto.response.ExampleResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ExampleService {
    @GET("api/v1/data")
    suspend fun getExampleData(): BaseResponse<ExampleResponseDto>

    @POST("api/v1/data")
    suspend fun postExampleData(
        @Body exampleRequestDto: ExampleRequestDto,
    ): BaseResponse<Unit>
}