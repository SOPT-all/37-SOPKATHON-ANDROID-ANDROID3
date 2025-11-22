package org.sopt.soptackthon_app_3.presentation.juwan.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun BookTopBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = SopkathonTheme.colors.primary
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = SopkathonTheme.colors.primary
                )
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "Book Service",
                style = SopkathonTheme.typography.heading.headingSb20,
                color = SopkathonTheme.colors.white
            )

            Text(
                text = "Share more, care more!",
                style = SopkathonTheme.typography.body.bodyM13,
                color = SopkathonTheme.colors.secondary
            )
        }

//        Image(
//            painter = painterResource(id = R.drawable.img_charactermain),
//            contentDescription = null
//        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewBookTopbar() {
    SopkathonTheme {
        BookTopBar()
    }
}