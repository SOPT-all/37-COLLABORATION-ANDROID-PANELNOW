package org.sopt.sopt_collaboration_panelnow.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray4
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.White

@Composable
fun PointSection(
    pointsText: String,
    onExchangeClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {
            PointTitleRow()
            Spacer(Modifier.height(8.dp))
            PointValueRow(pointsText)
        }

        Spacer(Modifier.width(20.dp))

        CustomButton(
            onClick = onExchangeClick,
            modifier = Modifier.width(125.dp),
        )

    }
}

@Composable
private fun PointTitleRow(
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Icon(
            painter = painterResource(id = R.drawable.ic_point),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )

        Spacer(Modifier.width(10.dp))

        Text(
            text = "나의 포인트",
            style = PanelNowTheme.typography.titleSb16,
        )

    }
}

@Composable
private fun PointValueRow(
    pointsText: String,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Text(
            text = pointsText,
            style = PanelNowTheme.typography.titleBd24
        )

        Spacer(Modifier.width(10.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )

    }
}


@Composable
fun PointTransactionsSection(
    modifier: Modifier = Modifier,
    pointsText: String = "4,500P",
    onExchangeClick: () -> Unit = {},

    ) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {

        Text(
            text = "포인트 내역",
            modifier = Modifier.padding(horizontal = 16.dp),
            style = PanelNowTheme.typography.titleSb16,
        )

        Spacer(modifier = Modifier.height(2.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
        ) {

            Surface(
                modifier = Modifier.fillMaxWidth(), color = White,
                shape = RoundedCornerShape(12.dp),
                tonalElevation = 8.dp
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    PointSection(pointsText = pointsText, onExchangeClick = onExchangeClick)
                }
            }

            Image(
                painter = painterResource(id = R.drawable.img_point_character),
                contentDescription = "Point Character",
                modifier = Modifier
                    .width(138.dp)
                    .height(64.dp)
                    .align(Alignment.TopEnd)
                    .offset(y = (-62).dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PointTransactionsSectionPreview() {
    Scaffold(
        containerColor = Gray4
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PointTransactionsSection(
                modifier = Modifier.padding(top = 16.dp),
                pointsText = "4,500P",
            )
        }

    }
}
