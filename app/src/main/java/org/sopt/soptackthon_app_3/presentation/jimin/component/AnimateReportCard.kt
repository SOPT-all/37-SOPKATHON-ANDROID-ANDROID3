package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun AnimateReportCard(
    title: String,
    imgRes: Int,
    content: String,
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
                title = title,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            ProgressBorderCard(
                cardRadius = 8.dp,
                content = {
                    Column (
                        modifier = Modifier.padding(horizontal = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(
                            painter = painterResource(imgRes),
                            contentDescription = null,
                            modifier = modifier
                                .fillMaxWidth()
                                .clip(
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = SopkathonTheme.colors.primary300
                                ),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = content,
                            color = SopkathonTheme.colors.primary500,
                            style = SopkathonTheme.typography.body.bodyM14,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal
                        )
                    }

                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimateReportCardPreview() {
    AnimateReportCard(
        title = "Pre-Service Report",
        imgRes = R.drawable.pre_img,
        content = "Hello, this is Sarah Johnson.\n" +
                "I’ll be arriving today at 11:10 PM to begin the Grocery Shopping service.\n" +
                "What I’ll bring:\n" +
                "- Cleaning supplies\n" +
                "- Shopping bags\n" +
                "- Face mask\n" +
                "Please relax while I take care of everything for you. I’m looking forward to helping!",
        isVisible = true

    )
}