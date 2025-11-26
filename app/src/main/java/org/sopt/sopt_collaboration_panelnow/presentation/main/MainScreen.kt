package org.sopt.sopt_collaboration_panelnow.presentation.main

import CustomNavigatorBar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.*

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination: Route? = navBackStackEntry?.destination?.route?.let { route ->
        when {
            route.contains("Home") -> Home
            route.contains("Survey") -> Survey
            route.contains("Event") -> Event
            route.contains("Exchange") -> Exchange
            route.contains("MyAction") -> MyAction
            route.contains("Detail") -> Detail(-1, -1)
            else -> null
        }
    }

    val showBottomBar = currentDestination in listOf(
        Home,
        Survey,
        Event,
        Exchange,
        MyAction
    )

    val items = listOf(
        NavigationItem.SurveyItem,
        NavigationItem.EventItem,
        NavigationItem.HomeItem,
        NavigationItem.ExchangeItem,
        NavigationItem.MyActionItem
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                CustomNavigatorBar(
                    items = items,
                    centerIndex = items.indexOf(NavigationItem.HomeItem),
                    currentRoute = currentDestination,
                    onItemClick = { item ->
                        if (currentDestination == item.route) {
                            return@CustomNavigatorBar
                        }

                        navController.navigate(item.route) {
                            popUpTo(Home) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        },
        containerColor = PanelNowTheme.colors.white
    ) {
            padding ->
        NaviHost(
            navController = navController,
            innerPadding = padding
        )
    }
}

