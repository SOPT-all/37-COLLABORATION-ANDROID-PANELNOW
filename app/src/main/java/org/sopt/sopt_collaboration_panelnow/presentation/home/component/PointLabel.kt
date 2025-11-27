package org.sopt.sopt_collaboration_panelnow.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.SubBlue

@Composable
fun PointLabel(
    points: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .background(SubBlue, CircleShape)
            .padding(horizontal = 10.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = points,
            color = PanelNowTheme.colors.mainBlue,
            style = PanelNowTheme.typography.bodyM12,
            textAlign = TextAlign.Center
        )
    }

}


@Preview
@Composable
private fun PointLabelPreview() {
    PointLabel(points = "230P")
}
