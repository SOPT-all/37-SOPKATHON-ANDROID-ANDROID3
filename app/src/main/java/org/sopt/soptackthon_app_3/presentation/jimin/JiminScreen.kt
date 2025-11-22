package org.sopt.soptackthon_app_3.presentation.jimin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.jimin.component.AnimateReportCard
import org.sopt.soptackthon_app_3.presentation.jimin.component.BookingInfoCard
import org.sopt.soptackthon_app_3.presentation.jimin.component.ProgressBorderCard
import org.sopt.soptackthon_app_3.presentation.jimin.component.ProgressCard
import org.sopt.soptackthon_app_3.presentation.jimin.component.ProgressContentTitle
import org.sopt.soptackthon_app_3.presentation.jimin.component.ProgressTitle
import org.sopt.soptackthon_app_3.presentation.jimin.viewmodel.JiminViewModel


@Composable
fun JiminRoute(
    progressViewModel: JiminViewModel = viewModel(),
    navigateToYubin: () -> Unit
){

    val progressUiState by progressViewModel.uiState.collectAsStateWithLifecycle()

    //val progressTimeUiState by progressViewModel.timer.collectAsStateWithLifecycle()

    val progressTimeVisibleUiState by progressViewModel.timeUiState.collectAsStateWithLifecycle()

    JiminScreen(
        locateText = progressUiState.locateText,
        dateText = progressUiState.dateText,
        startTime = progressUiState.startTime,
        duration = progressUiState.duration,
        cashText = progressUiState.cashText,
        bookingInfoModel = progressUiState.bookingInfoModel,
        preContent = progressUiState.preContent,
        animateContent = progressUiState.animateContent,
        isAnimateVisible = progressTimeVisibleUiState.isVisible,
        navigateToYubin = navigateToYubin
    )
}


@Composable
fun JiminScreen (
    locateText: String,
    dateText: String,
    startTime: String,
    duration: String,
    cashText: Int,
    bookingInfoModel: BookingInfoModel,
    preContent: String,
    animateContent: String,
    isAnimateVisible: Boolean,
    modifier : Modifier = Modifier,
    navigateToYubin:() -> Unit = {}
){

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.white)
    ){
        ProgressTitle(
            title = "Service progress",
            subTitle = "Your reservation is confirmed!\n" +
                    "We’ll keep you updated as things progress.",
            modifier = Modifier
                    .background(
                color = SopkathonTheme.colors.primary500
            )
        )

        Column (
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ){

            ProgressContentTitle(
                title = "Booking Information",
                modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
            )

            BookingInfoCard(
                locateText = locateText,
                dateText = dateText,
                startTime = startTime,
                duration = duration,
                cashText = cashText,
                bookingInfoModel = BookingInfoModel(
                    reportContent = bookingInfoModel.reportContent,
                    reportBackgroundColor = bookingInfoModel.reportBackgroundColor,
                    reportCardHorizontalPadding = bookingInfoModel.reportCardHorizontalPadding
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            ProgressContentTitle(
                title = "Pre-Service Report",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProgressBorderCard(
                cardRadius = 8.dp,
                content = {
                    ProgressCard(
                        content = preContent,
                        backgroundColor = SopkathonTheme.colors.primary300,
                        horizontalPadding = 23.dp
                    )
                },
            )

            Spacer(modifier = Modifier.height(10.dp))

            AnimateReportCard(
                animateContent = animateContent,
                isVisible = isAnimateVisible
            )

            Spacer(modifier = Modifier.height(60.dp))

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun ReviewJiminScreen(){
    SopkathonTheme {
        JiminScreen(
            locateText = "String",
            dateText = "String",
            startTime = "String",
            duration = "String",
            cashText = 70,
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
            animateContent = "Hello, this is Sarah Johnson.\n" +
                    "\n" +
                    "I will be visiting today at 23:10 to begin the Grocery Shopping service.\n" +
                    "\n" +
                    "What I'm bringing:\n" +
                    "- Cleaning supplies\n" +
                    "- Shopping bags\n" +
                    "- Face mask\n" +
                    "\n" +
                    "Please feel free to relax while I handle everything. Looking forward to helping!",
            isAnimateVisible = true
        )
    }
}