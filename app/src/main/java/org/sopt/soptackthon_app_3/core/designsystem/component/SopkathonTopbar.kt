package org.sopt.soptackthon_app_3.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
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
fun SopkathonTopbar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SopkathonTheme.colors.primary)
            .padding(horizontal = 13.dp, vertical = 13.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_back_arrow),
            contentDescription = null,
            tint = SopkathonTheme.colors.white
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ReviewSopkathonTopbar() {
    SopkathonTheme {
        SopkathonTopbar()
    }
}