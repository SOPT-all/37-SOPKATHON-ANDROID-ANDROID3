package org.sopt.soptackthon_app_3.presentation.doyeon.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun HelperServiceList(
    serviceList: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        serviceList.forEach { service ->
            Text(
                text = service,
                style = SopkathonTheme.typography.body.bodyM14.copy(fontWeight = FontWeight.Normal),
                color = SopkathonTheme.colors.primary800
            )
        }
    }
}

@Preview
@Composable
private fun HelperServiceListPreview() {
    SopkathonTheme {
        HelperServiceList(
            serviceList = listOf(
                "House Keeping",
                "Grocery Shopping",
                "House Keeping",
                "Grocery Shopping",
            ),
        )
    }
}