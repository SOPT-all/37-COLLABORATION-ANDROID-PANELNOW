package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NaviHost(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController, startDestination = Route.Home.path,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        composable(Route.Home.path) { }
        composable(Route.Survey.path) { }
        composable(Route.Event.path) {  }
        composable(Route.Exchange.path) {  }
        composable(Route.MyAction.path) {  }

    }
}
