package org.sopt.soptackthon_app_3.presentation.doyeon.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun HelperBio(
    bio: String,
) {
    Text(
        text = bio,
        style = SopkathonTheme.typography.body.bodyM14.copy(fontWeight = FontWeight.Normal)
    )
}