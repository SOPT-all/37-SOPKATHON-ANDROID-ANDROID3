package org.sopt.soptackthon_app_3.presentation.doyeon.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun HelperHourRates(
    hourRates: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_helper_money),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(28.dp),
        )

        Spacer(Modifier.weight(1f))

        Text(
            text = hourRates,
            style = SopkathonTheme.typography.heading.headingSb20,
            color = SopkathonTheme.colors.primary
        )
    }
}

@Preview
@Composable
private fun HelperHourRatesPreview() {
    SopkathonTheme {
        HelperHourRates(
            hourRates = "$35/hr",
        )
    }
}