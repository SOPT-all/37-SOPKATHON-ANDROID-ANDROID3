package org.sopt.soptackthon_app_3.presentation.doyeon.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun HelperDetailTitle(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Helper Info",
            style = SopkathonTheme.typography.heading.headingSb20,
            color = SopkathonTheme.colors.white
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "Check out detailed helper information.",
            style = SopkathonTheme.typography.body.bodyM13,
            color = SopkathonTheme.colors.secondary
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun HelperDetailTitlePreview() {
    SopkathonTheme {
        HelperDetailTitle()
    }
}