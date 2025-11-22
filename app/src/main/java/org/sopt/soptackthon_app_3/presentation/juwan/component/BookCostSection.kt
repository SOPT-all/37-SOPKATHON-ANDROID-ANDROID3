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
    estimated: String,
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
                color = SopkathonTheme.colors.primary500,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Hourly Rate"
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = rate
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Duration"
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = duration
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
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Hourly Rate"
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = rate
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun ReviewBookCostSection() {
    SopkathonTheme {
        BookCostSection(
            rate = "10000",
            duration = "2",
            estimated = "20000",
            modifier = Modifier
        )

    }
}