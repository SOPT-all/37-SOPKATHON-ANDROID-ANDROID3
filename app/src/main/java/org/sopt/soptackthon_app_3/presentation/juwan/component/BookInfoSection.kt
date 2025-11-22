package org.sopt.soptackthon_app_3.presentation.juwan.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun BookInfoSection(
    title: String,
    modifier: Modifier = Modifier,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = SopkathonTheme.colors.white,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = SopkathonTheme.colors.primary300,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        leftIcon?.let {
            Icon(
                imageVector = ImageVector.vectorResource(id = leftIcon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        Text(
            text = title,
            style = SopkathonTheme.typography.body.bodyM14,
            color = SopkathonTheme.colors.primary800,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.weight(1f))

        rightIcon?.let {
            Icon(
                imageVector = ImageVector.vectorResource(id = rightIcon),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ReviewBookInfoSection() {
    SopkathonTheme {
        BookInfoSection(
            title = "제목",
            leftIcon = R.drawable.ic_book_calendar,
            rightIcon = R.drawable.ic_dropdown
        )
    }
}