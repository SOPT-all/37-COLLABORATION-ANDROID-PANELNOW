package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
        composable<Home> { } // 이 안에 각자 스크린 넣으시면 됩니다
        composable<Survey> { }
        composable<Event> { }
        composable<Exchange> {
            PointExchangeRoute(navController)
        }
        composable<MyAction> {
        }
        composable<Detail> { backStakEntry ->
            val productId = backStakEntry.arguments?.getInt("productId") ?: -1

            PointDetailRoute(productId)
        }

    }
}
