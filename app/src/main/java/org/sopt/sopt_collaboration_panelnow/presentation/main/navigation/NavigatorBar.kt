package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
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
 fun NavigatorBarItem(
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
