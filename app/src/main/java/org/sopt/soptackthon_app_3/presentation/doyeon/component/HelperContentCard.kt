package org.sopt.soptackthon_app_3.presentation.doyeon.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun HelperContentCard(
    title: String,
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = 16.dp,
    borderColor: Color = SopkathonTheme.colors.primary300,
    content: @Composable BoxScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = SopkathonTheme.typography.title.titleSb16,
            color = SopkathonTheme.colors.black
        )

        Spacer(Modifier.height(8.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(12.dp))
                .background(SopkathonTheme.colors.white)
                .border(
                    width = 1.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(12.dp),
                )
        ) {
            Box(
                modifier = Modifier
                    .background(SopkathonTheme.colors.white)
                    .padding(vertical = 20.dp, horizontal = horizontalPadding)
            ) {
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HelperContentCardPreview() {
    SopkathonTheme {
        HelperContentCard(
            title = "Services Provided",
        ) {
            Column {
                Text(
                    text = "House Keeping",
                    style = SopkathonTheme.typography.body.bodyM14,
                    color = SopkathonTheme.colors.black
                )
                Text(
                    text = "House Keeping",
                    style = SopkathonTheme.typography.body.bodyM14,
                    color = SopkathonTheme.colors.black
                )
            }
        }
    }
}