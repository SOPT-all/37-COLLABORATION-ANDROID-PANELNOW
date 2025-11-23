package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun CustomNavigator() {
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val items = listOf(
        NavigationItem.SurveyItem,
        NavigationItem.EventItem,
        NavigationItem.HomeItem,
        NavigationItem.ExchangeItem,
        NavigationItem.MyActionItem,
    )

    Scaffold(
        containerColor = Color(0xFFF5F5F5),
        bottomBar = {
            CustomNavigatorBar(
                items = items,
                centerIndex = items.indexOf(NavigationItem.HomeItem),
                currentRoute = currentRoute,
                onItemClick = { item ->
                    if (currentRoute == item.route.path) return@CustomNavigatorBar

                    navController.navigate(item.route.path) {
                        popUpTo(Route.Home.path) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }) { innerPadding ->
        NaviHost(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}
