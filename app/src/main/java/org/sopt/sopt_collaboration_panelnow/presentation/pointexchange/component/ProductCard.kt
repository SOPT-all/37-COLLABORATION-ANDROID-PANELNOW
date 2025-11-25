package org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .width(160.dp)
            .noRippleClickable(onClick)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = title,
            modifier = Modifier
                .width(160.dp)
                .height(116.dp),
        )

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
            businessDays = "3",
            points = 3200,
            onClick = {},
        )
    }
}
