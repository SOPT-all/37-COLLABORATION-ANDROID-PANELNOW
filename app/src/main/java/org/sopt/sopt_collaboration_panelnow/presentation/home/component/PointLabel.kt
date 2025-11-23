package org.sopt.sopt_collaboration_panelnow.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.MainBlue
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.SubBlue



@Composable
fun PointLabel(points: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(48.dp)

            .height(25.dp)
            .background(SubBlue, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = points,
            modifier
                .fillMaxWidth()
                .padding(3.dp),
            color = MainBlue,
            fontWeight = FontWeight.W500,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }

}


@Preview
@Composable
private fun PointLabelPreview() {
    PointLabel(points = "230P")
}
