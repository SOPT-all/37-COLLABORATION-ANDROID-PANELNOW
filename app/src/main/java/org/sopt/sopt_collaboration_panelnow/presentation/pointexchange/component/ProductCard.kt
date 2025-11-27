package org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.sopt_collaboration_panelnow.core.common.extension.noRippleClickable
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme

@Composable
fun ProductCard(
    imageUrl: String,
    title: String,
    businessDays: String,
    points: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .noRippleClickable(onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.38f)
                .border(
                    width = 0.5.dp,
                    color = PanelNowTheme.colors.gray1,
                    shape = RoundedCornerShape(12.dp),
                )
                .background(
                    color = PanelNowTheme.colors.gray4,
                    shape = RoundedCornerShape(12.dp),
                )
                .clip(RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center,
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = title,
                modifier = Modifier.fillMaxSize(0.725f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            style = PanelNowTheme.typography.titleM14,
            color = PanelNowTheme.colors.gray6,
            modifier = Modifier.width(125.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = businessDays,
            style = PanelNowTheme.typography.titleM12,
            color = PanelNowTheme.colors.gray1,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "%,dP".format(points),
            style = PanelNowTheme.typography.titleSb16,
            color = PanelNowTheme.colors.gray6,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MyPointCardPreview() {
    PanelNowTheme {
        ProductCard(
            imageUrl = "",
            title = "네이버페이 포인트쿠폰 3000원권",
            businessDays = "3 영업일 소요",
            points = 3200,
            onClick = {},
        )
    }
}
