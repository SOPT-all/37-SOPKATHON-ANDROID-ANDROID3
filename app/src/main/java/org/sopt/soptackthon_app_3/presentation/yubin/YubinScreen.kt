package org.sopt.soptackthon_app_3.presentation.yubin

import CompactUserInformationComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.main.component.MainBottomBar
import org.sopt.soptackthon_app_3.presentation.yubin.viewmodel.HelperFilter
import org.sopt.soptackthon_app_3.presentation.yubin.viewmodel.YubinViewModel


@Composable
fun YubinRoute(
    navigateToDoyeon: () -> Unit,
    viewModel: YubinViewModel = viewModel(),
) {
    YubinScreen(
        navigateToDoyeon = navigateToDoyeon,
        viewModel = viewModel
    )
}

@Composable
fun YubinScreen(
    modifier: Modifier = Modifier,
    navigateToDoyeon: () -> Unit = {},
    viewModel: YubinViewModel = viewModel(),
) {
    // ViewModel의 상태 관찰
    val helperList by viewModel.helperList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val currentFilter by viewModel.currentFilter.collectAsState()

    var searchText by remember { mutableStateOf("") }

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
                        Spacer(modifier = modifier.width(30.dp))
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
                        value = searchText,
                        onValueChange = {
                            searchText = it
                            viewModel.searchHelpers(it)
                        },
                        placeholder = {
                            Text(
                                "What kind of helper are you looking for?",
                                style = SopkathonTheme.typography.caption.captionR12,
                                color = SopkathonTheme.colors.primary500
                            )
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Search",
                                tint = SopkathonTheme.colors.primary500
                            )
                        },
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
                TopSearchAndTitleSection(
                    currentFilter = currentFilter,
                    onFilterChange = { filter -> viewModel.updateFilter(filter) }
                )

                // 로딩 또는 에러 상태 처리
                when {
                    isLoading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                color = SopkathonTheme.colors.primary
                            )
                        }
                    }

                    errorMessage != null -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "Error: $errorMessage",
                                    color = Color.Red,
                                    style = SopkathonTheme.typography.body.bodyM14
                                )
                                Button(
                                    onClick = { viewModel.fetchHelperList() },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = SopkathonTheme.colors.primary
                                    )
                                ) {
                                    Text("Retry")
                                }
                            }
                        }
                    }

                    helperList.isEmpty() -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No helpers found",
                                style = SopkathonTheme.typography.body.bodyM14,
                                color = SopkathonTheme.colors.primary500
                            )
                        }
                    }

                    else -> {
                        // 헬퍼 목록 표시
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                                .background(SopkathonTheme.colors.primary200)
                        ) {
                            items(helperList) { user ->
                                CompactUserInformationComponent(
                                    user = user,
                                    onUserClick = { navigateToDoyeon() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TopSearchAndTitleSection(
    modifier: Modifier = Modifier,
    currentFilter: HelperFilter,
    onFilterChange: (HelperFilter) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(SopkathonTheme.colors.primary200)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(SopkathonTheme.colors.primary200)
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp, 40.dp)
                    .background(SopkathonTheme.colors.primary200)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(100.dp, 40.dp)
                    .background(SopkathonTheme.colors.primary200)
            )
        }

        Text(
            text = "Helper List",
            style = SopkathonTheme.typography.title.titleSb16,
            color = Color.Black,
            modifier = Modifier.offset(y = (-10).dp)
        )
    }

    FilterButtons(
        currentFilter = currentFilter,
        onFilterChange = onFilterChange
    )
}

@Composable
private fun FilterButtons(
    currentFilter: HelperFilter,
    onFilterChange: (HelperFilter) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterButton(
            text = "All",
            isSelected = currentFilter is HelperFilter.ALL,
            onClick = { onFilterChange(HelperFilter.ALL) }
        )
        FilterButton(
            text = "Popularity",
            isSelected = currentFilter is HelperFilter.POPULARITY,
            onClick = { onFilterChange(HelperFilter.POPULARITY) }
        )
        FilterButton(
            text = "Distance",
            isSelected = currentFilter is HelperFilter.DISTANCE,
            onClick = { onFilterChange(HelperFilter.DISTANCE) }
        )
    }
}

@Composable
private fun FilterButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
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
            .clickable(onClick = onClick),
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