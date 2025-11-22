//package org.sopt.soptackthon_app_3.data.dto.request
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.UseSerializers
//import androidx.compose.ui.graphics.Color
//
//@Serializable
//class UserInformationDto (
//    val imageURL: String, // 서버 명세 반영
//    val name: String,
//    val about: String, // 서버 명세 반영 (소개글)
//    val rate: Float, // 서버 명세 반영
//    val distance: String,
//    val verified: Boolean // 서버 명세 반영
//)
//
//
//
//
//// 서버의 전체 응답 구조
//@Serializable
//data class HelperListServerResponse(
//    val status: Int,
//    val message: String,
//    val data: List<HelperDto> // 헬퍼 목록
//)
//목록
//fun HelperDto.toCompactUser(profileImagePlaceholder: Color = Color(0xFFE0E0E0)): CompactUser {
//    return CompactUser(CompactUser
//        name = this.name,
//        description = this.about, // about 필드를 description으로 매핑
//        rating = this.rate.toDouble(),
//        distance = this.distance,
//        isVerified = this.verified,
//        profileImagePlaceholder = profileImagePlaceholder // 이미지 URL은 Composable에서 직접 사용
//    )
//}
//
//// 기존 CompactUser는 DTO와 UI 상태를 분리하기 위해 유지합니다.
//data class CompactUser(
//    val name: String,
//    val description: String,
//    val rating: Double,
//    val distance: String,
//    val isVerified: Boolean = true,
//    val profileImagePlaceholder: Any // URL (String) 또는 Placeholder Color를 담을 수 있도록 Any로 변경
//)
