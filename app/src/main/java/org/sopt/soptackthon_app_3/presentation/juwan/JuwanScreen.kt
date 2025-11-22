package org.sopt.soptackthon_app_3.presentation.juwan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.component.SopkathonButton
import org.sopt.soptackthon_app_3.core.designsystem.component.SopkathonTextField
import org.sopt.soptackthon_app_3.core.designsystem.component.SopkathonTopbar
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookCostSection
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookEssential
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookInfoSection
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookServiceSelect
import org.sopt.soptackthon_app_3.presentation.juwan.component.BookTopBar
import org.sopt.soptackthon_app_3.presentation.juwan.viewmodel.JuwanUiEvent
import org.sopt.soptackthon_app_3.presentation.juwan.viewmodel.JuwanUiState
import org.sopt.soptackthon_app_3.presentation.juwan.viewmodel.JuwanViewModel
import org.sopt.soptackthon_app_3.presentation.juwan.viewmodel.ServiceData.services


@Composable
fun JuwanRoute(
    navigateToJimin: () -> Unit,
    viewModel: JuwanViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            navigateToJimin()
        }
    }

    JuwanScreen(
        uiState = uiState,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun JuwanScreen(
    modifier: Modifier = Modifier,
    uiState: JuwanUiState = JuwanUiState(),
    onEvent: (JuwanUiEvent) -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(
                    color = SopkathonTheme.colors.primary200
                ),
        ) {
            item {
                SopkathonTopbar()
            }

            item {
                BookTopBar()
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = SopkathonTheme.colors.white,
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                        )
                        .zIndex(1F)
                ) { }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                BookEssential(
                    title = "Select Services",
                )
            }

            items(count = services.size, contentType = { it }) { index ->
                val service = services[index]
                Spacer(modifier = Modifier.height(8.dp))
                BookServiceSelect(
                    serviceText = service.name,
                    onBookServiceSelect = {
                        onEvent(JuwanUiEvent.UpdateServiceOfferId(service.id))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    isSelected = uiState.serviceOfferId == service.id
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                BookEssential(
                    title = "Locate",
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                BookInfoSection(
                    title = uiState.locate.ifEmpty { "Select Location" },
                    leftIcon = R.drawable.ic_fill_locatioon,
                    rightIcon = null,
                    modifier = Modifier.padding(horizontal = 16.dp),
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                BookEssential(
                    title = "Date",
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                BookInfoSection(
                    title = uiState.visitDate.ifEmpty { "Select Date" },
                    leftIcon = R.drawable.ic_fill_calendar,
                    rightIcon = null,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                BookEssential(
                    title = "Available time",
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    BookInfoSection(
                        title = uiState.startTime.ifEmpty { "Start" },
                        leftIcon = null,
                        rightIcon = R.drawable.ic_dropdown,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = ":",
                        style = SopkathonTheme.typography.title.titleSb16,
                        color = SopkathonTheme.colors.primary900,
                    )
                    BookInfoSection(
                        title = uiState.endTime.ifEmpty { "End" },
                        leftIcon = null,
                        rightIcon = R.drawable.ic_dropdown, // 오타 수정
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Special request",
                    style = SopkathonTheme.typography.title.titleSb16,
                    color = SopkathonTheme.colors.primary900,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                SopkathonTextField(
                    value = uiState.specialRequests,
                    placeholder = "Enter any special requests or notes for the helper",
                    onValueChanged = {
                        onEvent(JuwanUiEvent.UpdateSpecialRequests(it))
                    },
                    borderColor = SopkathonTheme.colors.primary300,
                    backgroundColor = SopkathonTheme.colors.white,
                    onFocusChanged = {},
                    singleLine = false,
                    modifier = Modifier
                        .height(160.dp)
                        .padding(horizontal = 16.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Cost",
                    style = SopkathonTheme.typography.title.titleSb16,
                    color = SopkathonTheme.colors.primary900,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))

                BookCostSection(
                    rate = "$${String.format("%.2f", uiState.estimatedFee)}/hour",
                    duration = "${uiState.fixedDuration.toInt()} hours", // 고정 2시간
                    serviceEstimate = "$${String.format("%.2f", uiState.serviceEstimate)}", // Rate * 2
                    bookingFee = "$${String.format("%.2f", uiState.reservationFee)}", // 고정 $5
                    totalEstimate = "$${String.format("%.2f", uiState.totalEstimated)}", // Service + Fee
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }

        if (uiState.error != null) {
            Text(
                text = uiState.error,
                color = SopkathonTheme.colors.primary,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(16.dp)
                    .background(
                        color = SopkathonTheme.colors.white,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = SopkathonTheme.colors.white)
                .align(Alignment.BottomEnd)
        ) {
            SopkathonButton(
                label = if (uiState.isLoading) "Loading..." else "Confirm Booking",
                onClick = { onEvent(JuwanUiEvent.ConfirmBooking) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .offset(y = (-30).dp),
                isEnabled = !uiState.isLoading && uiState.serviceOfferId > 0
            )
        }

        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

private fun calculateHours(start: String, end: String): Double {
    if (start.isEmpty() || end.isEmpty()) return 0.0

    try {
        val startHour = start.split(":")[0].toInt()
        val endHour = end.split(":")[0].toInt()
        return (endHour - startHour).toDouble().coerceAtLeast(0.0)
    } catch (e: Exception) {
        return 0.0
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewJuwanScreen() {
    SopkathonTheme {
        JuwanScreen(
            modifier = Modifier.fillMaxSize(),
            uiState = JuwanUiState(),
            onEvent = {}
        )
    }
}