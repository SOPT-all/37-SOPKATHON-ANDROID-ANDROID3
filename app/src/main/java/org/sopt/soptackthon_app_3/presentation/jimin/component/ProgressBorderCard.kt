package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun ProgressBorderCard(
    cardRadius: Dp,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = SopkathonTheme.colors.white,
            )
            .border(
                width = 1.dp,
                color = SopkathonTheme.colors.primary300,
                shape = RoundedCornerShape(cardRadius)
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun ProgressBorderCardPreview() {
    ProgressBorderCard(
        cardRadius = 8.dp,
        content = {
            ProgressCard(
                content = "Hello, this is Sarah Johnson.\n" +
                        "\n" +
                        "I will be visiting today at 23:10 to begin the Grocery Shopping service.\n" +
                        "\n" +
                        "What I'm bringing:\n" +
                        "- Cleaning supplies\n" +
                        "- Shopping bags\n" +
                        "- Face mask\n" +
                        "\n" +
                        "Please feel free to relax while I handle everything. Looking forward to helping!",
                backgroundColor = SopkathonTheme.colors.primary300,
                horizontalPadding = 23.dp
            )
        },
    )
}