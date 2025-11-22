package org.sopt.soptackthon_app_3.data.service

import org.sopt.soptackthon_app_3.data.dto.base.BaseResponse
import org.sopt.soptackthon_app_3.data.dto.response.HelperDetailResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface HelperDetailService {

    @GET("/api/helpers/{helperId}")
    suspend fun getHelperInfo(
        @Path(value = "helperId") helperId: Int,
    ): BaseResponse<HelperDetailResponseDto>

}