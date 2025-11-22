package org.sopt.soptackthon_app_3.presentation.yubin

data class CompactUser(
    val name: String,
    val description: String,
    val rating: Double,
    val distance: String,
    val isVerified: Boolean = true,
    val profileImagePlaceholder: String
)