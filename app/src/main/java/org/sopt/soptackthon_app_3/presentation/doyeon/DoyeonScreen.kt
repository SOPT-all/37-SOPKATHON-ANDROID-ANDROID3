package org.sopt.soptackthon_app_3.presentation.doyeon

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
fun DoyeonRoute(
    navigateToJuwan: () -> Unit,
) {
    DoyeonScreen(
        navigateToJuwan = navigateToJuwan
    )
}

@Composable
fun DoyeonScreen(
    modifier: Modifier = Modifier,
    navigateToJuwan: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.white)
    ) {
        Text(
            text = "Doyoun Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToJuwan),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewDoyounScreen() {
    SopkathonTheme {
        DoyeonScreen()
    }
}