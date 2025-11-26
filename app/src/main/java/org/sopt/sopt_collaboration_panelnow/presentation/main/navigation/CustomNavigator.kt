import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.Home
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.NavigationItem
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.NavigatorBarItem
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.Route

//package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation
//
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.graphics.Color
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.toRoute
//
//@Composable
//fun CustomNavigator() {
//    val navController = rememberNavController()
//
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = backStackEntry?.toRoute<Route>()
//
//    val items = listOf(
//        NavigationItem.SurveyItem,
//        NavigationItem.EventItem,
//        NavigationItem.HomeItem,
//        NavigationItem.ExchangeItem,
//        NavigationItem.MyActionItem,
//    )
//
//    Scaffold(
//        containerColor = Color(0xFFF5F5F5),
//        bottomBar = {
//            CustomNavigatorBar(
//                items = items,
//                centerIndex = items.indexOf(NavigationItem.HomeItem),
//                currentRoute = currentRoute,
//                onItemClick = { item ->
//                    navController.navigate(item.route) {
//                        popUpTo(Home::class) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                })
//        }) { innerPadding ->
//        NaviHost(
//            navController = navController,
//            innerPadding = innerPadding
//        )
//    }
//}

@Composable
fun CustomNavigatorBar(
    items: List<NavigationItem>,
    centerIndex: Int,
    currentRoute: Route?,
    onItemClick: (NavigationItem) -> Unit
) {
    if (items.isEmpty() || centerIndex !in items.indices) return
    val centerItem = items[centerIndex]
    val leftItems = items.take(centerIndex)
    val rightItems = items.drop(centerIndex + 1)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(R.drawable.ic_nav_background),
                contentDescription = "Navigator Background",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .aspectRatio(402f / 162f),
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 6.dp)
                    .offset(y = (-35).dp),
                verticalAlignment = Alignment.CenterVertically,

                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                leftItems.forEach { item ->
                    NavigatorBarItem(
                        item = item,
                        isSelected = currentRoute == item.route,
                        onClick = { onItemClick(item) }
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                rightItems.forEach { item ->
                    NavigatorBarItem(
                        item = item,
                        isSelected = currentRoute == item.route,
                        onClick = { onItemClick(item) }
                    )
                }
            }
        }
        FloatingActionButton(
            onClick = { onItemClick(centerItem) },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(height = 65.dp, width = 63.dp)
                .offset(y = (-40).dp),
            shape = CircleShape,
            containerColor = Color(0xFF00A8FF),
            contentColor = MaterialTheme.colorScheme.onPrimary
        ) {
            Icon(
                painter = painterResource(id = centerItem.selectedIcons),
                contentDescription = centerItem.label,
                tint = Color.Unspecified
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomNavigatorBarPreview() {
    var currentRoute by remember { mutableStateOf<Route?>(Home) }
    val items = listOf(
        NavigationItem.SurveyItem,
        NavigationItem.EventItem,
        NavigationItem.HomeItem,
        NavigationItem.ExchangeItem,
        NavigationItem.MyActionItem
    )
    Scaffold(
        containerColor = Color(0xFFE0F7FA),
        bottomBar = {
            CustomNavigatorBar(
                items = items,
                centerIndex = 2,
                currentRoute = currentRoute,
                onItemClick = { item ->
                    currentRoute = item.route
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFE0F7FA))
        )
    }
}
