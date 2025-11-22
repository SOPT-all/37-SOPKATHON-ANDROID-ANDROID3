package org.sopt.soptackthon_app_3.presentation.juwan.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun BookEssential(
    title: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = SopkathonTheme.colors.white,
            )
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                append(title)
                withStyle(style = SpanStyle(color = SopkathonTheme.colors.primary)) {
                    append(" *")
                }
            },
            style = SopkathonTheme.typography.title.titleSb16,
            color = SopkathonTheme.colors.primary900
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ReviewBookEssentail() {
    SopkathonTheme {
        BookEssential(
            title = "Locate",
        )
    }
}