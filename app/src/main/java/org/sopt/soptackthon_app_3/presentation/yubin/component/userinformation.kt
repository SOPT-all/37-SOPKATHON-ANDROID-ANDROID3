import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.yubin.CompactUser


@Composable
fun CompactUserInformationComponent(
    user: CompactUser,
    onUserClick: (CompactUser) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 8.dp, bottom = 16.dp)
            .clickable { onUserClick(user) },
        // 흰색 배경
        colors = CardDefaults.cardColors(containerColor = SopkathonTheme.colors.white),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {

            //이미지
            AsyncImage(
                model = user.profileImagePlaceholder,
                contentDescription = "",
                modifier = Modifier
                .size(60.dp)
                .background(color = SopkathonTheme.colors.primary800, shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop

            )

            Row(verticalAlignment = Alignment.CenterVertically) {

                // 사용자 정보
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = user.name,
                            style = SopkathonTheme.typography.title.titleSb16,
                            color = SopkathonTheme.colors.primary900
                        )
                        if (user.isVerified) {
                            Spacer(modifier = Modifier.width(4.dp))
                            // 인증 배지 아이콘 (파란색 체크 표시)
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.check),
                                contentDescription = "Verified",
                                tint = Color(0xFF1E88E5), // Material Design Blue
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    // 설명
                    Text(
                        text = user.description,
                        style = SopkathonTheme.typography.caption.captionR12,
                        color = SopkathonTheme.colors.primary800
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // 별점
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Rating",
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = user.rating.toString(),
                            style = SopkathonTheme.typography.caption.captionR12,
                            color = SopkathonTheme.colors.primary500
                        )
                    }


                    Spacer(modifier = Modifier.width(16.dp))
                    Row {
                        // 거리
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = "Distance",
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = user.distance,
                            style = SopkathonTheme.typography.caption.captionR12,
                            color = SopkathonTheme.colors.primary500
                        )
                    }

                }

                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Detail",
                    modifier = Modifier.size(24.dp),
                    tint = SopkathonTheme.colors.primary500
                )
            }
        }
    }

}


// 미리보기
@Preview(showBackground = true)
@Composable
fun PreviewCompactUserInformationComponent() {
    val sampleUser = CompactUser(
        name = "Sam Brick",
        description = "Home-cleaning pro who's great at                              keeping seniors company.",
        rating = 4.5,
        distance = "0.2 mi",
        isVerified = true,
        profileImagePlaceholder = ""
    )
    CompactUserInformationComponent(
        user = sampleUser,
        onUserClick = { /* Handle user click */ }
    )
}
