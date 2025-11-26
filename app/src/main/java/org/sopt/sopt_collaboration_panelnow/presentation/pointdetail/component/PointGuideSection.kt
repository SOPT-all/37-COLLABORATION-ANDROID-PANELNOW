package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.domain.entity.InfoSection

@Composable
fun PointGuideSection(
    infoSections: List<InfoSection>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 19.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = stringResource(R.string.point_detail_guide),
            style = PanelNowTheme.typography.titleSb16,
            color = PanelNowTheme.colors.gray6,
        )

        infoSections.forEach { section ->
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "▶ ${section.label}",
                    style = PanelNowTheme.typography.bodyR14,
                    color = PanelNowTheme.colors.gray6,
                )

                Text(
                    text = section.content,
                    style = PanelNowTheme.typography.bodyR14,
                    color = PanelNowTheme.colors.gray6,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPointGuideSection() {
    PanelNowTheme {
        PointGuideSection(
            infoSections = listOf(
                InfoSection(
                    label = "충전권 이용안내",
                    content = "네이버페이 포인트는 네이버쇼핑/네이버웹툰/네이버예약을 비롯한 45 만개 이상 가맹점에서 현금처럼 이용하실 수 있습니다."
                ),
                InfoSection(
                    label = "사용방법",
                    content = "모바일 : 네이버페이>우상단 삼선메뉴(=)클릭>결제>쿠폰>쿠폰 등록"
                ),
                InfoSection(
                    label = "이용가이드",
                    content = "포인트는 1인당 최대 200만원까지 보유하실 수 있습니다."
                )
            )
        )
    }
}