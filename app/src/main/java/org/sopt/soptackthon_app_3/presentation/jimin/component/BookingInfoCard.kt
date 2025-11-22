package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.jimin.BookingInfoModel
import org.sopt.soptackthon_app_3.presentation.jimin.JiminScreen

@Composable
fun BookingInfoCard(
    locateText: String,
    dateText: String,
    startTime: String,
    duration: String,
    cashText: Int,
    bookingInfoModel: BookingInfoModel,
    modifier: Modifier = Modifier
) {
    ProgressBorderCard(
        cardRadius = bookingInfoModel.reportCardRadius,
        content = {
            Column(
                modifier = Modifier
            ) {
                Row (
                    modifier = Modifier.padding(top = 5.dp, bottom = 16.dp),
                    verticalAlignment = Alignment.Top
                ){
                    ProgressInfoTitle(
                        iconRes = R.drawable.ic_locate,
                        title = "Locate",
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = locateText,
                        color = SopkathonTheme.colors.primary800,
                        style = SopkathonTheme.typography.caption.captionM12,
                        textAlign = TextAlign.Right
                    )
                }

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary100))

                Row (
                    modifier = Modifier.padding(vertical = 16.dp),
                    verticalAlignment = Alignment.Top
                ){
                    ProgressInfoTitle(
                        iconRes = R.drawable.ic_calender,
                        title = "Date",
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = dateText,
                        color = SopkathonTheme.colors.primary800,
                        style = SopkathonTheme.typography.caption.captionM12,
                        textAlign = TextAlign.Right
                    )
                }

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary100))

                Row (
                    modifier = Modifier.padding(vertical = 16.dp),
                    verticalAlignment = Alignment.Top
                ){
                    ProgressInfoTitle(
                        iconRes = R.drawable.ic_time,
                        title = "Time",
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Column (
                        modifier = Modifier.width(IntrinsicSize.Max),
                    ){
                        TimeField(
                            timeFieldTitle = "Start time",
                            timeFieldText = startTime
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        TimeField(
                            timeFieldTitle = "Duration",
                            timeFieldText = duration
                        )
                    }
                }

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary100))

                Column(
                    modifier = Modifier.padding(vertical = 16.dp),
                ) {
                    ProgressInfoTitle(
                        iconRes = R.drawable.ic_chat,
                        title = "Special request",
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    ProgressCard(
                        content = bookingInfoModel.reportContent,
                        backgroundColor = bookingInfoModel.reportBackgroundColor,
                        horizontalPadding = bookingInfoModel.reportCardHorizontalPadding
                    )
                }

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary100))

                Row (
                    modifier = Modifier.padding(top = 16.dp),
                    verticalAlignment = Alignment.Top
                ){
                    ProgressInfoTitle(
                        iconRes = R.drawable.ic_cash,
                        title = "Total cost",
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "${cashText}$",
                        color = SopkathonTheme.colors.primary800,
                        style = SopkathonTheme.typography.heading.headingSb20,
                        textAlign = TextAlign.Right
                    )
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun BookingInfoCardPreview(){
    BookingInfoCard(
        locateText = "1234 Maple Street Springfield,\n" +
                "IL 62704 USA",
        dateText = "2025 / 11 / 22",
        startTime = "9:00 am",
        duration = "2 Hour",
        cashText = 70,
        bookingInfoModel = BookingInfoModel(
            reportContent = "Please pay special attention to my parents and make sure they’re well taken care of.",
            reportBackgroundColor = SopkathonTheme.colors.primary200,
            reportCardHorizontalPadding = 18.dp
        )
    )
}