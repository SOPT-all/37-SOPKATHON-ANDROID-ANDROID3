package org.sopt.soptackthon_app_3.presentation.doyeon.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme

@Composable
fun HelperProfileCard(
    imgUrl: String,
    name: String,
    rate: Float,
    distance: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 32.dp,
            )
    ) {
        AsyncImage(
            model = imgUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .size(112.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
        )

        Spacer(Modifier.width(20.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HelperName(name)

            HelperDetail(rate, distance)

            VerificationButton()
        }
    }
}

@Composable
private fun HelperName(
    name: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            style = SopkathonTheme.typography.title.titleSb16,
            color = SopkathonTheme.colors.white
        )

        Spacer(Modifier.width(4.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_helper_verified),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier =
                Modifier
                    .size(16.dp),
        )
    }
}

@Composable
private fun HelperDetail(
    rate: Float,
    distance: String,
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_helper_star),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier =
                    Modifier
                        .size(16.dp),
            )

            Spacer(Modifier.width(4.dp))

            Text(
                text = rate.toString(),
                style = SopkathonTheme.typography.caption.captionR12,
                color = SopkathonTheme.colors.white
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_helper_locate),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier =
                    Modifier
                        .size(16.dp),
            )

            Spacer(Modifier.width(4.dp))

            Text(
                text = distance,
                style = SopkathonTheme.typography.caption.captionR12,
                color = SopkathonTheme.colors.white
            )
        }
    }
}

@Composable
private fun VerificationButton() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(SopkathonTheme.colors.white)
            .padding(vertical = 6.dp)
            .width(165.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_helper_checked),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier =
                Modifier
                    .size(14.dp),
        )

        Spacer(Modifier.width(8.dp))

        Text(
            text = "Verification Details",
            style = SopkathonTheme.typography.caption.captionM12,
            color = SopkathonTheme.colors.primary
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun HelperProfileCardPreview() {
    SopkathonTheme {
        HelperProfileCard(
            imgUrl = "TODO()",
            name = "Sam Brick",
            rate = 4.5f,
            distance = "0.2 mi",
        )
    }
}