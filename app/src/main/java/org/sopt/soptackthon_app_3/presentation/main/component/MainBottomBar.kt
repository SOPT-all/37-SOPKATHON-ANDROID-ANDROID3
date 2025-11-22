package org.sopt.soptackthon_app_3.presentation.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme


@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 16.dp,)
                .align(Alignment.BottomCenter),
            color = SopkathonTheme.colors.white
        ) {
            Column {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 2.dp,
                    color = SopkathonTheme.colors.primary200,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(horizontal = 60.dp, vertical = 8.dp)
                        .selectableGroup(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MainNavigationBarItem(
                        iconRes = R.drawable.ic_bottom_home,
                        title = "홈",
                        modifier = Modifier.weight(1F)
                    )

                    Box(modifier = Modifier
                        .size(60.dp)
                        .weight(1F))

                    MainNavigationBarItem(
                        iconRes = R.drawable.ic_bottom_m,
                        title = "마이",
                        modifier = Modifier.weight(1F)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-10).dp)
                .background(
                    color = SopkathonTheme.colors.primary,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_bottom_main),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
private fun MainNavigationBarItem(
    iconRes: Int,
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp),
        )
        Text(
            text = title,
            color = SopkathonTheme.colors.primary500,
            style = SopkathonTheme.typography.caption.captionR12
        )
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    SopkathonTheme {
        MainBottomBar()
    }
}