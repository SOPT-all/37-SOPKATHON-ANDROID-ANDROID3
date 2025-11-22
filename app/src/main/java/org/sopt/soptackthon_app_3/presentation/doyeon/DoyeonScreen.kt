package org.sopt.soptackthon_app_3.presentation.doyeon

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.soptackthon_app_3.core.designsystem.component.SopkathonButton
import org.sopt.soptackthon_app_3.core.designsystem.component.SopkathonTopbar
import org.sopt.soptackthon_app_3.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_3.presentation.doyeon.component.HelperBio
import org.sopt.soptackthon_app_3.presentation.doyeon.component.HelperContentCard
import org.sopt.soptackthon_app_3.presentation.doyeon.component.HelperDetailList
import org.sopt.soptackthon_app_3.presentation.doyeon.component.HelperDetailTitle
import org.sopt.soptackthon_app_3.presentation.doyeon.component.HelperHourRates
import org.sopt.soptackthon_app_3.presentation.doyeon.component.HelperProfileCard
import org.sopt.soptackthon_app_3.presentation.doyeon.component.HelperServiceList
import org.sopt.soptackthon_app_3.presentation.doyeon.viewmodel.DoyeonViewModel


@Composable
fun DoyeonRoute(
    navigateToJuwan: () -> Unit,
    viewModel: DoyeonViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val scrollState = rememberScrollState()

    DoyeonScreen(
        uiState = uiState,
        navigateToJuwan = navigateToJuwan,
        scrollState = scrollState
    )
}

@Composable
fun DoyeonScreen(
    uiState: DoyeonUiState,
    modifier: Modifier = Modifier,
    navigateToJuwan: () -> Unit = {},
    scrollState: ScrollState,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.primary200)
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            SopkathonTopbar(
                modifier = Modifier
                    .background(SopkathonTheme.colors.primary)
            )

            HelperDetailTitle(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SopkathonTheme.colors.primary)
                    .padding(
                        top = 11.dp,
                        start = 24.dp,
                        end = 24.dp
                    )
            )

            HelperProfileCard(
                imgUrl = uiState.imgUrl,
                name = uiState.name,
                rate = uiState.rate,
                distance = uiState.distance,
                modifier = Modifier
                    .background(SopkathonTheme.colors.primary)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(SopkathonTheme.colors.primary)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 20.dp,
                                topEnd = 20.dp
                            )
                        )
                        .background(color = SopkathonTheme.colors.primary200)
                )
            }

            HelperContentCard(
                title = "Services Provided",
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                HelperServiceList(
                    serviceList = uiState.serviceList,
                )
            }

            HelperContentCard(
                title = "About Me",
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                HelperBio(
                    bio = uiState.bio
                )
            }

            HelperContentCard(
                title = "Details",
                horizontalPadding = 16.dp,
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                HelperDetailList(
                    experience = uiState.experience,
                    availabilityList = uiState.availabilityList,
                    languageList = uiState.languageList,
                )
            }

            HelperContentCard(
                title = "Hour Rates",
                horizontalPadding = 16.dp,
                borderColor = SopkathonTheme.colors.primary,
                modifier = Modifier.padding(bottom = 154.dp)
            ) {
                HelperHourRates(
                    hourRates = uiState.hourRates,
                )
            }
        }

        SopkathonButton(
            label = "Request Booking",
            onClick = navigateToJuwan,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(SopkathonTheme.colors.white)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 28.dp
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewDoyounScreen() {
    val scrollState = rememberScrollState()

    SopkathonTheme {
        DoyeonScreen(
            uiState = DoyeonUiState(),
            navigateToJuwan = {},
            scrollState = scrollState
        )
    }
}
