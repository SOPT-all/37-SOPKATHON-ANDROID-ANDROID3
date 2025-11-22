package org.sopt.soptackthon_app_3.presentation.juwan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.core.util.noRippleClickable


@Composable
fun JuwanRoute(
    navigateToDoyeon: () -> Unit,
) {
    JuwanScreen(
        navigateToDoyeon = navigateToDoyeon
    )
}

@Composable
fun JuwanScreen(
    modifier: Modifier = Modifier,
    navigateToDoyeon: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.White)
    ) {
        Text(
            text = "Juwan Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToDoyeon),
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewJuwanScreen() {
    SopkathonTheme {
        JuwanScreen()
    }
}