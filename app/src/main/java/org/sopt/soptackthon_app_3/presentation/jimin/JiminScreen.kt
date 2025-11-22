package org.sopt.soptackthon_app_3.presentation.jimin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.jimin.component.ProgressContentTitle
import org.sopt.soptackthon_app_3.presentation.jimin.component.ProgressTitle


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
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.white)
    ){
        ProgressTitle(
            title = "Service progress",
            subTitle = "Your reservation is confirmed!\n" +
                    "We’ll keep you updated as things progress.",
            modifier = Modifier
                    .background(
                color = SopkathonTheme.colors.primary500
            )
        )

        Column (
            modifier = Modifier.padding(horizontal = 16.dp)
        ){

            ProgressContentTitle(
                title = "Booking Information",
                modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun ReviewJiminScreen(){
    SopkathonTheme {
        JiminScreen()
    }
}