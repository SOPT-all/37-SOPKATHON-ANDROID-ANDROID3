package org.sopt.soptackthon_app_3.presentation.juwan.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun BookCostSection(
    rate: String,
    duration: String,
    serviceEstimate: String,
    bookingFee: String,
    totalEstimate: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = SopkathonTheme.colors.white,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = SopkathonTheme.colors.primary300,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Hourly Rate",
                style = SopkathonTheme.typography.body.bodyM14,
                color = SopkathonTheme.colors.primary500
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = rate,
                style = SopkathonTheme.typography.body.bodyM14,
                color = SopkathonTheme.colors.primary800
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Duration",
                style = SopkathonTheme.typography.body.bodyM14,
                color = SopkathonTheme.colors.primary500
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = duration,
                style = SopkathonTheme.typography.body.bodyM14,
                color = SopkathonTheme.colors.primary800
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            thickness = 1.dp,
            color = SopkathonTheme.colors.primary300
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Service Estimate",
                style = SopkathonTheme.typography.body.bodyM14,
                color = SopkathonTheme.colors.primary500
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = serviceEstimate,
                style = SopkathonTheme.typography.body.bodyM14,
                color = SopkathonTheme.colors.primary800
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Booking Fee",
                style = SopkathonTheme.typography.body.bodyM14,
                color = SopkathonTheme.colors.primary500
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = bookingFee,
                style = SopkathonTheme.typography.body.bodyM14,
                color = SopkathonTheme.colors.primary800
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            thickness = 1.dp,
            color = SopkathonTheme.colors.primary300
        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Total Estimate",
                style = SopkathonTheme.typography.title.titleSb16,
                color = SopkathonTheme.colors.black
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = totalEstimate,
                style = SopkathonTheme.typography.title.titleSb16,
                color = SopkathonTheme.colors.primary
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ReviewBookCostSection() {
    SopkathonTheme {
        BookCostSection(
            rate = "$15.00/hour",
            duration = "2.5 hours",
            serviceEstimate = "$37.50",
            bookingFee = "$5.00",
            totalEstimate = "$42.50",
            modifier = Modifier.padding(16.dp)
        )
    }
}