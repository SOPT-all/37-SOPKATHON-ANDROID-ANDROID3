package org.sopt.soptackthon_app_3.presentation.juwan.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.core.util.noRippleClickable

@Composable
fun BookServiceSelect(
    serviceText: String,
    onBookServiceSelect: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    val (selectColor, borderColor) = when (isSelected) {
        true -> SopkathonTheme.colors.primary to SopkathonTheme.colors.secondary
        false -> SopkathonTheme.colors.primary300 to SopkathonTheme.colors.primary900
    }


    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = selectColor,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .noRippleClickable(onClick = onBookServiceSelect)
            .padding(vertical = 13.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = serviceText
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ReviewBookServiceSelect() {
    SopkathonTheme {
        BookServiceSelect(
            serviceText = "House Keeping",
            onBookServiceSelect = {},
        )
    }
}