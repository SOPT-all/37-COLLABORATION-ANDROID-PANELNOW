package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.common.extension.noRippleClickable
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme

@Composable
fun PointPaySection(
    label: String,
    myPoint: String,
    modifier: Modifier = Modifier,
    canPayed: Boolean = false,
    onPayClick: () -> Unit = {},
    @DrawableRes iconRes: Int? = null,
) {
    if (canPayed) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = PanelNowTheme.colors.white)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            iconRes?.let {
                Icon(
                    imageVector = ImageVector.vectorResource(id = it),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp)
                )
            }

            Text(
                text = "나의 포인트",
                style = PanelNowTheme.typography.bodyR14,
                color = PanelNowTheme.colors.gray1
            )

            Text(
                text = myPoint,
                style = PanelNowTheme.typography.titleSb16,
                color = PanelNowTheme.colors.mainBlue
            )

            PayButton(
                label = label,
                onPayClick = onPayClick,
                modifier = Modifier.weight(1f),
                isEnabled = true
            )
        }
    } else {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(color = PanelNowTheme.colors.white)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            PayButton(
                label = label,
                onPayClick = onPayClick,
                modifier = Modifier.fillMaxWidth(),
                isEnabled = false
            )
        }
    }
}

@Composable
private fun PayButton(
    label: String,
    onPayClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
) {
    val backgroundColor = if (isEnabled) {
        PanelNowTheme.colors.mainBlue
    } else {
        PanelNowTheme.colors.gray2
    }

    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 32.dp,
                    bottomEnd = 32.dp
                )
            )
            .noRippleClickable(
                onClick = onPayClick
            )
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = PanelNowTheme.typography.titleSb16,
            color = PanelNowTheme.colors.white
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewPointPaySection() {
    PanelNowTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .size(240.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PointPaySection(
                label = "500P 교환하기",
                myPoint = "4500P",
                canPayed = false,
                iconRes = R.drawable.ic_point
            )
            PointPaySection(
                label = "500P 교환하기",
                myPoint = "4500P",
                canPayed = true,
                iconRes = R.drawable.ic_point
            )
        }
    }
}