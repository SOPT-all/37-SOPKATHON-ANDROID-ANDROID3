package org.sopt.soptackthon_app_3.presentation.jimin.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun ProgressInfoTitle(
    iconRes: Int,
    title: String,
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier
    ){
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(22.dp),
            tint = SopkathonTheme.colors.primary
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = title,
            color = SopkathonTheme.colors.primary500,
            style = SopkathonTheme.typography.body.bodyM14
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProgressInfoTitlePreview() {
    SopkathonTheme {
        ProgressInfoTitle(
            iconRes = R.drawable.ic_locate,
            title = "Locate"
        )
    }
}