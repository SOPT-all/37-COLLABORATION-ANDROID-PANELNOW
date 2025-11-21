package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.core.common.extension.noRippleClickable

@Composable
fun PointPaySection(
    label: String,
    myPoint: String,
    modifier: Modifier = Modifier,
    canPayed: Boolean = false,
    @DrawableRes IconRes: Int? = null,
) {
    val ButtonWidth = when (canPayed) {
        true -> 1F
        false -> 0F
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconRes?.let {
            Icon(
                imageVector = ImageVector.vectorResource(id = it),
                contentDescription = null,
            )
        }

        Text(
            text = myPoint
        )

        PayButton(
            label = label,
            onPayClick = { /*TODO*/ },
            modifier = Modifier.weight(ButtonWidth),
            isEnabled = canPayed
        )

    }
}

@Composable
private fun PayButton(
    label: String,
    onPayClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
) {
    val (backgroundColor, textColor) = remember(isEnabled) {
        when (isEnabled) {
            true -> Color.Blue to Color.White
            false -> Color.Gray to Color.White
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 32.dp,
                    bottomEnd = 32.dp
                )
            )
            .noRippleClickable(onClick = onPayClick)
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = textColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewPointPaySection() {
    PointPaySection(
        label = "1000원 결제하기",
        myPoint = "1000",
    )
}