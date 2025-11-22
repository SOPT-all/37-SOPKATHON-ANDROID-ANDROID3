package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun TimeField(
    timeFieldTitle: String,
    timeFieldText: String,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier,
    ){
        Text(
            text = timeFieldTitle,
            color = SopkathonTheme.colors.primary800,
            style = SopkathonTheme.typography.caption.captionM12
        )

        Spacer(modifier = Modifier
            .width(10.dp)
            .weight(1f)
        )

        Text(
            text = timeFieldText,
            color = SopkathonTheme.colors.primary800,
            style = SopkathonTheme.typography.caption.captionR12
        )
    }
}