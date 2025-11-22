package org.sopt.soptackthon_app_3.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.soptackthon_app_3.presentation.doyeon.DoyeonRoute
import org.sopt.soptackthon_app_3.presentation.jimin.JiminRoute
import org.sopt.soptackthon_app_3.presentation.juwan.JuwanRoute
import org.sopt.soptackthon_app_3.presentation.yubin.YubinRoute

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = "doyeon"
        ) {

            composable(route = "juwan") {
                JuwanRoute(
                    navigateToDoyeon = { navController.navigateToDoyeon() }
                )
            }

            composable(route = "doyeon") {
                DoyeonRoute(
                    navigateToJimin = { navController.navigateToJimin() }
                )
            }

            composable(route = "jimin") {
                JiminRoute(
                    navigateToYubin = { navController.navigateToYubin() }
                )
            }


            composable(route = "yubin") {
                YubinRoute(
                    navigateToJuwan = { navController.navigateToJuwan() },
                )
            }
        }
    }
}