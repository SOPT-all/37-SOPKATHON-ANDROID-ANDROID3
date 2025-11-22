package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun AnimateReportCard(
    animateContent: String,
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    enter: EnterTransition = fadeIn(),
    exit: ExitTransition = fadeOut(),
) {

    AnimatedVisibility(
        visible = isVisible,
        enter = enter,
        exit = exit

    ) {
        Column {
            ProgressContentTitle(
                title = "New Report",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProgressBorderCard(
                cardRadius = 8.dp,
                content = {
                    ProgressCard(
                        content = animateContent,
                        backgroundColor = SopkathonTheme.colors.primary300,
                        horizontalPadding = 23.dp
                    )
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimateReportCardPreview() {
    AnimateReportCard(
        animateContent = "Hello, this is Sarah Johnson.\n" +
                "\n" +
                "I will be visiting today at 23:10 to begin the Grocery Shopping service.\n" +
                "\n" +
                "What I'm bringing:\n" +
                "- Cleaning supplies\n" +
                "- Shopping bags\n" +
                "- Face mask\n" +
                "\n" +
                "Please feel free to relax while I handle everything. Looking forward to helping!",
        isVisible = false

    )
}