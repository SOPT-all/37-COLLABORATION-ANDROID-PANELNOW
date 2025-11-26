package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.designsystem.component.PanelNowTopBar
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.miniTestList
import org.sopt.sopt_collaboration_panelnow.presentation.home.screen.HomeScreen
import org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.PointDetailRoute
import org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.PointExchangeRoute


@Composable
fun NaviHost(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Home::class,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        composable<Home> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PanelNowTheme.colors.gray4)
            ) {
                PanelNowTheme {
                    PanelNowTopBar(
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = stringResource(R.string.top_bar_logo),
                                tint = Color.Unspecified,
                            )
                        }
                    )
                }
                HomeScreen(
                    miniTests = miniTestList,
                    onExchangeClick = {
                        navController.navigate(Exchange) {
                            popUpTo(Home) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

            }

        }
        // 이 안에 각자 스크린 넣으시면 됩니다
        composable<Survey> { }
        composable<Event> { }
        composable<Exchange> {
            PointExchangeRoute(navController)
        }
        composable<MyAction> {
        }
        composable<Detail> { backStakEntry ->
            val currentPoint = backStakEntry.arguments?.getInt("currentPoint") ?: -1
            val productId = backStakEntry.arguments?.getInt("productId") ?: -1

            PointDetailRoute(currentPoint, productId, navController)
        }

    }
}
