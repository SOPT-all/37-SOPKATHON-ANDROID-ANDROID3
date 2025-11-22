package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun ProgressContentTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        modifier = modifier.fillMaxWidth(),
        color = SopkathonTheme.colors.black,
        style = SopkathonTheme.typography.title.titleSb16,
    )
}

@Preview(showBackground = true)
@Composable
private fun ProgressContentTitlePreview() {
    ProgressContentTitle(
        title = "Booking Information",
    )
}