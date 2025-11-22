package org.sopt.soptackthon_app_3.presentation.yubin

import CompactUser
import CompactUserInformationComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.core.util.noRippleClickable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.presentation.main.component.MainBottomBar
import java.time.format.TextStyle


val mockHelperList = listOf(
    CompactUser("a", "Sam Brick", 1.0, "4.5mi", true, profileImagePlaceholder = ""),
    CompactUser("hb", "Jane Doe", 2.0, "1.5mi", false, profileImagePlaceholder = ""),
    CompactUser("c", "Alex Kim", 2.0, "4.2mi", true, profileImagePlaceholder = "")
)

@Composable
fun YubinRoute(
    navigateToDoyeon: () -> Unit,
) {
    YubinScreen(
        navigateToDoyeon = navigateToDoyeon
    )
}

@Composable
fun YubinScreen(
    modifier: Modifier = Modifier,
    navigateToDoyeon: () -> Unit = {},
) {
    Scaffold(
        bottomBar = { MainBottomBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SopkathonTheme.colors.primary)
                    .padding(start = 16.dp, top = 30.dp, end = 16.dp, bottom = 20.dp)
            ) {
                Column {
                    Row(
                        modifier.height(IntrinsicSize.Max), verticalAlignment = Alignment.Bottom
                    ) {
                        Image(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = "logo",
                            Modifier
                                .width(150.dp)
                                .height(60.dp)
                                .padding(start = 2.dp, end = 10.dp)
                        )
                        Spacer(modifier=modifier.width(30.dp))
                        Image(
                            painter = painterResource(R.drawable.img_character1),
                            contentDescription = "logo",
                            Modifier
                                .width(200.dp)
                                .height(70.dp)
                                .padding(start = 2.dp, end = 10.dp)
                        )


                    }

                    // 검색창
                    OutlinedTextField(
                        value = "",
                        onValueChange = { /* Handle search text */ },
                        placeholder = {
                            Text(
                                "What kind of helper are you looking for?",
                                style = SopkathonTheme.typography.caption.captionR12,
                                color = SopkathonTheme.colors.primary500
                            )
                        },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint =SopkathonTheme.colors.primary500)},
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = SopkathonTheme.colors.primary100,
                                shape = RoundedCornerShape(size = 12.dp)
                            )
                            .padding(start = 16.dp, end = 12.dp),

                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = SopkathonTheme.colors.white,
                            unfocusedContainerColor = SopkathonTheme.colors.white,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                }


            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.85f)
                    .padding(top = 0.dp)
                    .background(SopkathonTheme.colors.primary200)
            ) {
                TopSearchAndTitleSection()

                // 헬퍼 목록 영역
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(SopkathonTheme.colors.primary200)

                    // BottomBar 영역 확보
                ) {
                    // Mock Data를 사용하여 목록을 채웁니다.
                    items(mockHelperList) { user ->
                        CompactUserInformationComponent(
                            user = user,
                            onUserClick = { /* Handle click */ }
                        )
                    }
                }

            }

        }
    }
}

@Composable
private fun TopSearchAndTitleSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(SopkathonTheme.colors.primary200)

    ) {
        // 상단 로고/슬로건 영역 (이미지상 흰색 박스 처리)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(SopkathonTheme.colors.primary200)

        ) {
            // Dear.Nest 로고 자리
            Box(
                modifier = Modifier
                    .size(100.dp, 40.dp)
                    .background(SopkathonTheme.colors.primary200)
            )
            Spacer(modifier = Modifier.width(8.dp))
            // 빈 공간
            Box(
                modifier = Modifier
                    .size(100.dp, 40.dp)
                    .background(SopkathonTheme.colors.primary200)
            )
        }


        // Helper List 타이틀
        Text(
            text = "Helper List",
            style = SopkathonTheme.typography.title.titleSb16,
            color = Color.Black,
            modifier = Modifier.offset(y = (-10).dp) // 검색창이 위로 올라가면서 생긴 공간 메우기
        )
    }

    // 필터 버튼 영역
    FilterButtons()
}

@Composable
private fun FilterButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterButton(text = "All", isSelected = true)
        FilterButton(text = "Popularity", isSelected = false)
        FilterButton(text = "Distance", isSelected = false)
    }
}

@Composable
private fun FilterButton(text: String, isSelected: Boolean) {
    val backgroundColor =
        if (isSelected) SopkathonTheme.colors.white else SopkathonTheme.colors.primary300
    val borderColor = if (isSelected) SopkathonTheme.colors.primary else Color.LightGray
    val textColor =
        if (isSelected) SopkathonTheme.colors.primary else SopkathonTheme.colors.primary500

    Text(
        text = text,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .border(1.dp, borderColor, RoundedCornerShape(20.dp))
            .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
            .clickable { /* Handle filter click */ },
        color = textColor,
        style = SopkathonTheme.typography.caption.captionM12
    )
}


@Preview(showBackground = true)
@Composable
private fun PreviewYubinScreen() {
    SopkathonTheme {
        YubinScreen()
    }

}


