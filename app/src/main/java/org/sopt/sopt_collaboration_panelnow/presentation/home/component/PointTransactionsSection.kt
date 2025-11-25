package org.sopt.sopt_collaboration_panelnow.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray4
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowFontBold
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowFontSemiBold

@Composable
fun PointTransactionCard(
    modifier: Modifier = Modifier,
    pointsText: String = "4,500P",
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        CardSection(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_point),
                            contentDescription = "point",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp)

                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "나의 포인트",
                            fontFamily = PanelNowFontSemiBold,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W600
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = pointsText,
                            fontFamily = PanelNowFontBold,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W700
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = "arrow_right",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(20.dp))

                CustomButton(
                    onClick = { },
                    modifier = Modifier.width(125.dp),
                    text = "교환하기"
                )
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

@Composable
fun PointTransactionsSection(
    modifier: Modifier = Modifier,
    pointsText: String = "4,500P",
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 10.dp)
    ) {
        Text(
            text = "포인트 내역",
            fontFamily = PanelNowFontSemiBold,
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600
        )

        Spacer(modifier = Modifier.height(2.dp))

        PointTransactionCard(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            pointsText = pointsText
        )
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
