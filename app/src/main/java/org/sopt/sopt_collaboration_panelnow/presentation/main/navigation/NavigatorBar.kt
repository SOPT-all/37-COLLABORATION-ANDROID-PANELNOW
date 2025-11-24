package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.R

sealed class NavigationItem(
    val route: Route,
    val label: String,
    @DrawableRes val selectedIcons: Int,
    @DrawableRes val unselectedIcons: Int,
) {
    data object HomeItem : NavigationItem(
        Home,
        label = "",
        selectedIcons = R.drawable.ic_nav_home,
        unselectedIcons = R.drawable.ic_nav_home
    )

    data object SurveyItem : NavigationItem(
        Survey,
        "설문조사",
        selectedIcons = R.drawable.ic_nav_survey_on,
        unselectedIcons = R.drawable.ic_nav_survey
    )

    data object EventItem : NavigationItem(
        Event,
        "이벤트",
        selectedIcons = R.drawable.ic_nav_event_on,
        unselectedIcons = R.drawable.ic_nav_event
    )

    data object ExchangeItem :
        NavigationItem(
            Exchange,
            "포인트 교환",
            selectedIcons = R.drawable.ic_nav_exchange_on,
            unselectedIcons = R.drawable.ic_nav_exchange
        )

    data object MyActionItem :
        NavigationItem(
            MyAction,
            "내 활동",
            selectedIcons = R.drawable.ic_nav_myaction_on,
            unselectedIcons = R.drawable.ic_nav_myaction
        )
}

@Composable
private fun NavigatorBarItem(
    item: NavigationItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val icons = if (isSelected) item.selectedIcons else item.unselectedIcons
    Column(
        modifier = Modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icons),
            contentDescription = item.label,
            tint = Color.Unspecified,
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = item.label,
            color = if (isSelected)
                Color(0xFF00A8FF)
            else
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
fun CustomNavigatorBar(
    items: List<NavigationItem>,
    centerIndex: Int,
    currentRoute:Route?,
    onItemClick: (NavigationItem) -> Unit
) {
    val barColor = Color.White
    if (items.isEmpty() || centerIndex !in items.indices) return
    val centerItem = items[centerIndex]
    val leftItems = items.take(centerIndex)
    val rightItems = items.drop(centerIndex + 1)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(
                        alpha = 0.99f,
                        compositingStrategy = CompositingStrategy.Offscreen
                    )
                    .drawWithContent {
                        drawContent()
                        val rx = 36.dp.toPx()
                        val ry = 55.dp.toPx()
                        val centerX = size.width / 2f
                        val centerY = (5).dp.toPx()
                        val topLeft = Offset(
                            x = centerX - rx,
                            y = centerY - ry
                        )
                        drawOval(
                            color = Color.Transparent,
                            topLeft = topLeft,
                            size = Size(width = rx * 2, height = ry * 2),
                            blendMode = BlendMode.Clear
                        )
                    },
                color = barColor,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
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
        }
        FloatingActionButton(
            onClick = { onItemClick(centerItem) },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 12.dp),
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
