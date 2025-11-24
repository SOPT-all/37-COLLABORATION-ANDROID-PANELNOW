package org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme

@Composable
fun MyPointCard(
    currentPoint: Int,
    exchangedPoint: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_point),
                    contentDescription = "Point Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp),
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "나의 포인트",
                    style = PanelNowTheme.typography.titleSb16,
                    color = PanelNowTheme.colors.gray6,
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "%,dP".format(currentPoint),
                    style = PanelNowTheme.typography.titleBd24,
                    color = PanelNowTheme.colors.gray6,
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "화살표",
                    tint = PanelNowTheme.colors.gray2,
                    modifier = Modifier.size(24.dp),
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Row {
                Text(
                    text = "현재까지 교환한 포인트 ",
                    style = PanelNowTheme.typography.titleM14,
                    color = PanelNowTheme.colors.gray1,
                )

                Text(
                    text = "%,dP".format(exchangedPoint),
                    style = PanelNowTheme.typography.titleM14,
                    color = PanelNowTheme.colors.mainBlue,
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.img_point_character),
            contentDescription = "Point Character",
            modifier = Modifier
                .width(138.dp)
                .height(64.dp)
                .align(Alignment.BottomEnd),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MyPointCardPreview() {
    PanelNowTheme {
        MyPointCard(
            currentPoint = 4500,
            exchangedPoint = 4000,
        )
    }
}
