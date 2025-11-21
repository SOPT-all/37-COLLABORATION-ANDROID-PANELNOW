package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme

@Composable
fun PointGuideSection(
    guideText: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            )
            .padding(horizontal = 16.dp, vertical = 19.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = stringResource(id = R.string.point_detail_guide),
            style = PanelNowTheme.typography.titleSb16,
            color = PanelNowTheme.colors.gray6,
            modifier = Modifier
                .align(Alignment.Start),
        )

        Text(
            text = guideText,
            style = PanelNowTheme.typography.bodyR14,
            color = PanelNowTheme.colors.gray6,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPointGuideSection() {
    PanelNowTheme {
        PointGuideSection(
            guideText = "포인트 상세 설명 예시 텍스트"
        )
    }
}