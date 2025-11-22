package org.sopt.soptackthon_app_3.presentation.jimin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.soptackthon_app_3.R
import org.sopt.soptackthon_app_3.core.designsystem.component.SopkathonButton
import org.sopt.soptackthon_app_3.core.designsystem.component.SopkathonTopbar
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.jimin.component.AnimateReportCard
import org.sopt.soptackthon_app_3.presentation.jimin.component.BookingInfoCard
import org.sopt.soptackthon_app_3.presentation.jimin.component.LinearProgressBar
import org.sopt.soptackthon_app_3.presentation.jimin.component.ProgressContentTitle
import org.sopt.soptackthon_app_3.presentation.jimin.component.ProgressTitle
import org.sopt.soptackthon_app_3.presentation.jimin.viewmodel.JiminViewModel


@Composable
fun JiminRoute(
    progressViewModel: JiminViewModel = viewModel(),
    navigateToYubin: () -> Unit,
) {

    val progressUiState by progressViewModel.uiState.collectAsStateWithLifecycle()

    val progressTimeVisibleUiState by progressViewModel.timeUiState.collectAsStateWithLifecycle()

    JiminScreen(
        locateText = progressUiState.locateText,
        dateText = progressUiState.dateText,
        startTime = progressUiState.startTime,
        confirmText = progressUiState.confirmText,
        serviceFee = progressUiState.serviceFee,
        bookingFee = progressUiState.bookingFee,
        cashText = progressUiState.cashText,
        bookingInfoModel = progressUiState.bookingInfoModel,
        preContent = progressUiState.preContent,
        isPreAnimateVisible = progressTimeVisibleUiState.isPreVisible,
        isPostAnimateVisible = progressTimeVisibleUiState.isPostVisible,
        navigateToYubin = navigateToYubin
    )
}


@Composable
fun JiminScreen(
    locateText: String,
    dateText: String,
    startTime: String,
    confirmText: String,
    serviceFee: Double,
    bookingFee: Double,
    cashText: Double,
    bookingInfoModel: BookingInfoModel,
    preContent: String,
    isPreAnimateVisible: Boolean,
    isPostAnimateVisible: Boolean,
    modifier: Modifier = Modifier,
    navigateToYubin: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    )

    {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = SopkathonTheme.colors.white)
                .systemBarsPadding()
        ) {
            SopkathonTopbar(
                background = SopkathonTheme.colors.white,
                iconColor = SopkathonTheme.colors.primary800
            )

            ProgressTitle(
                title = "Service progress",
                subTitle = "Your reservation is confirmed!\n" +
                        "You can check the progress of your request here.\n" +
                        "We’ll safely follow up with your parents."
            )

            Spacer(modifier = Modifier.height(32.dp))

            LinearProgressBar()

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier
                    .background(color = SopkathonTheme.colors.primary200)
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                ProgressContentTitle(
                    title = "Booking Info",
                    modifier = Modifier.padding(top = 32.dp, bottom = 8.dp)
                )

                BookingInfoCard(
                    locateText = locateText,
                    dateText = dateText,
                    startTime = startTime,
                    confirmTime = confirmText,
                    serviceFee = serviceFee,
                    bookingFee = bookingFee,
                    cashText = cashText,
                    bookingInfoModel = BookingInfoModel(
                        reportContent = bookingInfoModel.reportContent,
                        reportBackgroundColor = SopkathonTheme.colors.primary200,
                        reportCardHorizontalPadding = bookingInfoModel.reportCardHorizontalPadding
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                AnimateReportCard(
                    title = "Pre-Service Report",
                    imgRes = R.drawable.pre_img,
                    content = "Hello, this is Sarah Johnson.\n" +
                            "I’ll be arriving today at 11:10 PM to begin the Grocery Shopping service.\n" +
                            "What I’ll bring:\n" +
                            "- Cleaning supplies\n" +
                            "- Shopping bags\n" +
                            "- Face mask\n" +
                            "Please relax while I take care of everything for you. I’m looking forward to helping!",
                    isVisible = isPreAnimateVisible
                )

                Spacer(modifier = Modifier.height(24.dp))

                AnimateReportCard(
                    title = "Post-Service Report",
                    imgRes = R.drawable.new_img,
                    content = "Hello, this is Sarah Johnson.\n I’ve just finished the Grocery Shopping service for your parent.\n" +
                            "Here’s what I completed today:\n" +
                            "Purchased all items on the list\n" +
                            "Organized everything neatly at home\n" +
                            "Double-checked expiration dates and stored items properly\n" +
                            "Your parent is doing well, and everything was taken care of safely and comfortably.\u2028 If you have any additional requests or follow-ups, please feel free to let me know.\n" +
                            "I was happy to help today!",
                    isVisible = isPostAnimateVisible
                )

                Spacer(modifier = Modifier.height(154.dp))
            }
        }
        SopkathonButton(
            label = "Complete Request $${serviceFee}",
            onClick = navigateToYubin,
            modifier = Modifier
                .background(color = SopkathonTheme.colors.white)
                .align(alignment = Alignment.BottomCenter)
                .padding(top = 12.dp, bottom = 28.dp)
                .padding(horizontal = 16.dp),
            isEnabled = if (isPostAnimateVisible) true else false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewJiminScreen() {
    SopkathonTheme {
        JiminScreen(
            locateText = "String",
            dateText = "String",
            startTime = "String",
            confirmText = "String",
            serviceFee = 60.0,
            bookingFee = 10.0,
            cashText = 70.0,
            bookingInfoModel = BookingInfoModel(
                reportContent = "Please pay special attention to my parents and make sure they’re well taken care of.",
                reportBackgroundColor = SopkathonTheme.colors.primary200,
                reportCardHorizontalPadding = 18.dp
            ),
            preContent = "Hello, this is Sarah Johnson.\n" +
                    "\n" +
                    "I will be visiting today at 23:10 to begin the Grocery Shopping service.\n" +
                    "\n" +
                    "What I'm bringing:\n" +
                    "- Cleaning supplies\n" +
                    "- Shopping bags\n" +
                    "- Face mask\n" +
                    "\n" +
                    "Please feel free to relax while I handle everything. Looking forward to helping!",
            isPreAnimateVisible = true,
            isPostAnimateVisible = true
        )
    }
}