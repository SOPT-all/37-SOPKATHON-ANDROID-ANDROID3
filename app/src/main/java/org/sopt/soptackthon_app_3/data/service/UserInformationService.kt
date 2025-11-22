package org.sopt.soptackthon_app_3.data.service

import org.sopt.soptackthon_app_3.data.dto.base.BaseResponse
import org.sopt.soptackthon_app_3.data.dto.response.HelperDetailResponseDto
import org.sopt.soptackthon_app_3.data.dto.response.UserInformationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserInformationService {
    @GET("/api/helpers")
    suspend fun getUserInfo(
    ): BaseResponse<UserInformationResponse>
}


