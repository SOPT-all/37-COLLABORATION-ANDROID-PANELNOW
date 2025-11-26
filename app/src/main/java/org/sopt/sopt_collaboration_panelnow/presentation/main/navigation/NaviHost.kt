package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import org.sopt.sopt_collaboration_panelnow.core.designsystem.component.PanelNowTopBar
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.MiniTestModel
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
            ){
                PanelNowTopBar(
                    content = {
                        Text(
                            text = "패널나우",
                            style = PanelNowTheme.typography.titleSb16,
                            color = PanelNowTheme.colors.gray6
                        )
                    },
                    onAlarmClick = {  },
                    onProfileClick = {  }

                )
                HomeScreen(
                    pointsText = "4,500P",
                    miniTests = miniTestList
                )

            }

        } // 이 안에 각자 스크린 넣으시면 됩니다
        composable<Survey> { }
        composable<Event> { }
        composable<Exchange> {
            PointExchangeRoute()
        }
        composable<MyAction> {
            PointDetailRoute()
        }

    }
}
