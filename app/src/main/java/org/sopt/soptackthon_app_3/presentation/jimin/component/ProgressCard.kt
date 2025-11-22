package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun ProgressCard(
    content: String,
    backgroundColor: Color,
    horizontalPadding: Dp = 20.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = horizontalPadding, vertical = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = content,
            color = SopkathonTheme.colors.black,
            style = SopkathonTheme.typography.body.bodyM14,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProgressCardPreview() {
    Column {
        ProgressCard(
            content = "Please pay special attention to my parents and make sure they’re well taken care of.",
            backgroundColor = SopkathonTheme.colors.primary200,
            horizontalPadding = 18.dp
        )

        Spacer(modifier = Modifier.height(10.dp))

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
    }
}