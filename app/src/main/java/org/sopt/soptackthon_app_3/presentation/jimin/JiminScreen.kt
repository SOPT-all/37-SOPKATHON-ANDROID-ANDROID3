package org.sopt.soptackthon_app_3.presentation.jimin

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
fun JiminRoute(
    navigateToYubin: () -> Unit
){
    JiminScreen(
        navigateToYubin = navigateToYubin
    )
}
@Composable
fun JiminScreen (
    modifier : Modifier = Modifier,
    navigateToYubin:() -> Unit = {}
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
    ){
        Text(
            text = "Jimin Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToYubin)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun ReviewJiminScreen(){
    SopkathonTheme {
        JiminScreen()
    }
}
