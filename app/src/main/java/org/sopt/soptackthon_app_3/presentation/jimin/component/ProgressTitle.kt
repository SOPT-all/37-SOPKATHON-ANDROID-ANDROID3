package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun ProgressTitle(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = SopkathonTheme.colors.primary500
            )
            .padding(horizontal = 16.dp)
            .padding(top = 32.dp, bottom = 50.dp)
    ){
        Text(
            text = title,
            color = SopkathonTheme.colors.black,
            style = SopkathonTheme.typography.title.titleSb16
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = subTitle,
            color = SopkathonTheme.colors.black,
            style = SopkathonTheme.typography.body.bodyM14
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun ProgressTitlePreview() {
    ProgressTitle(
        title = "Service progress",
        subTitle = "Your reservation is confirmed!\n" +
                "We’ll keep you updated as things progress."
    )
}