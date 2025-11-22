package org.sopt.soptackthon_app_3.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.core.util.noRippleClickable

@Composable
fun SopkathonButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
) {
    val backgrondColor = when (isEnabled) {
        true -> SopkathonTheme.colors.primary
        false -> SopkathonTheme.colors.primary900
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgrondColor,
                shape = RoundedCornerShape(16.dp)
            )
            .noRippleClickable(onClick)
            .padding(vertical = 15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = SopkathonTheme.typography.title.titleB16,
            color = SopkathonTheme.colors.white
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewSopkactonButton() {
    SopkathonTheme {
        SopkathonButton(label = "Button", onClick = {})
    }
}
