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
import androidx.compose.ui.text.font.FontWeight
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
    confirmTime: String,
    serviceFee: Int,
    bookingFee: Int,
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
                    modifier = Modifier.padding(bottom = 20.dp),
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

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary300))

                Row (
                    modifier = Modifier.padding(vertical = 20.dp),
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

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary300))

                Row (
                    modifier = Modifier.padding(vertical = 20.dp),
                    verticalAlignment = Alignment.Top
                ){
                    ProgressInfoTitle(
                        iconRes = R.drawable.ic_time,
                        title = "Available Time",
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = startTime,
                        color = SopkathonTheme.colors.primary800,
                        style = SopkathonTheme.typography.caption.captionM12,
                        textAlign = TextAlign.Right
                    )
                }

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary300))

                Row(
                    modifier = Modifier.padding(vertical = 20.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    ProgressInfoTitle(
                        iconRes = R.drawable.ic_check,
                        title = "Confirmed Time",
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = confirmTime,
                        color = SopkathonTheme.colors.primary800,
                        style = SopkathonTheme.typography.caption.captionM12,
                        textAlign = TextAlign.Right
                    )
                }

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary300))

                Column(
                    modifier = Modifier.padding(vertical = 20.dp),
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

                HorizontalDivider(modifier = Modifier.border(width = 1.dp, color = SopkathonTheme.colors.primary300))

                Column (
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 20.dp)
                ){
                    Row (
                    ){
                        Text(
                            text = "Service Fee",
                            color = SopkathonTheme.colors.primary500,
                            style = SopkathonTheme.typography.body.bodyM14,
                            fontWeight = FontWeight.Normal
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "$${serviceFee}",
                            color = SopkathonTheme.colors.primary800,
                            style = SopkathonTheme.typography.body.bodyM14
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row {
                        Text(
                            text = "Booking Fee",
                            color = SopkathonTheme.colors.primary500,
                            style = SopkathonTheme.typography.body.bodyM14,
                            fontWeight = FontWeight.Normal
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "$${bookingFee}",
                            color = SopkathonTheme.colors.primary800,
                            style = SopkathonTheme.typography.body.bodyM14
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row (
                        modifier = Modifier,
                        verticalAlignment = Alignment.Top
                    ){
                        Text(
                            text = "Total Cost",
                            color = SopkathonTheme.colors.black,
                            style = SopkathonTheme.typography.title.titleSb14
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = "$${cashText}",
                            color = SopkathonTheme.colors.primary,
                            style = SopkathonTheme.typography.heading.headingSb20,
                            textAlign = TextAlign.Right
                        )
                    }
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun BookingInfoCardPreview(){
    SopkathonTheme {
        BookingInfoCard(
            locateText = "1234 Maple Street Springfield,\n" +
                    "IL 62704 USA",
            dateText = "2025 / 11 / 22",
            startTime = "9:00 am",
            confirmTime = "2 Hour",
            serviceFee = 70,
            bookingFee = 10,
            cashText = 70,
            bookingInfoModel = BookingInfoModel(
                reportContent = "Please pay special attention to my parents and make sure they’re well taken care of.",
                reportBackgroundColor = SopkathonTheme.colors.primary200,
                reportCardHorizontalPadding = 18.dp
            )
        )
    }
}