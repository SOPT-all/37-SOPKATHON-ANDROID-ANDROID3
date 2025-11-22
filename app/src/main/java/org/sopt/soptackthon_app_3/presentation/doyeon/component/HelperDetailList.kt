package org.sopt.soptackthon_app_3.presentation.doyeon.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.doyeon.model.HelperAvailabilityData

@Composable
fun HelperDetailList(
    experience: String,
    availabilityList: List<HelperAvailabilityData>,
    languageList: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        DetailItem(
            icon = R.drawable.ic_helper_calender,
            title = "Experience"
        ) {
            HelperExperience(experience)
        }

        HelperDivider()

        DetailItem(
            icon = R.drawable.ic_helper_time,
            title = "Availability"
        ) {
            HelperAvailability(availabilityList)
        }

        HelperDivider()

        DetailItem(
            icon = R.drawable.ic_helper_language,
            title = "Language"
        ) {
            HelperLanguage(languageList)
        }
    }
}

@Composable
private fun DetailItem(
    @DrawableRes icon: Int,
    title: String,
    content: @Composable ColumnScope.() -> Unit,
) {
    Row(
        modifier = Modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(28.dp),
        )

        Spacer(Modifier.width(12.dp))

        Column {
            Text(
                text = title,
                style = SopkathonTheme.typography.caption.captionR12,
                color = SopkathonTheme.colors.primary500,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            content()
        }
    }
}

@Composable
private fun HelperExperience(
    experience: String,
) {
    Text(
        text = experience + "years",
        style = SopkathonTheme.typography.body.bodyM14,
        color = SopkathonTheme.colors.primary800,
    )
}

@Composable
private fun HelperAvailability(
    availabilityList: List<HelperAvailabilityData>,
) {
    Column {
        availabilityList.forEach { availability ->
            Row {
                Text(
                    text = availability.weekday,
                    style = SopkathonTheme.typography.body.bodyM14,
                    color = SopkathonTheme.colors.primary800,
                    modifier = Modifier.width(32.dp)
                )
                Text(
                    text = availability.time,
                    style = SopkathonTheme.typography.body.bodyM14,
                    color = SopkathonTheme.colors.primary800,
                )
            }
        }
    }
}

@Composable
private fun HelperLanguage(
    languageList: List<String>,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(top = 4.dp)
    ) {
        languageList.forEach { language ->
            Text(
                text = language,
                style = SopkathonTheme.typography.caption.captionM12,
                color = SopkathonTheme.colors.black,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(SopkathonTheme.colors.primary200)
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }
    }
}

@Composable
private fun HelperDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(vertical = 16.dp),
        thickness = 1.dp,
        color = SopkathonTheme.colors.primary300,
    )
}

@Preview
@Composable
private fun HelperDetailListPreview() {
    val alst = listOf(
        HelperAvailabilityData(
            weekday = "MON",
            time = "1:00 PM – 5:00 PM"
        ),
        HelperAvailabilityData(
            weekday = "MON",
            time = "1:00 PM – 5:00 PM"
        )
    )

    SopkathonTheme {
        HelperDetailList(
            experience = "3",
            availabilityList = alst,
            languageList = listOf(
                "English",
                "English"
            ),
        )
    }
}