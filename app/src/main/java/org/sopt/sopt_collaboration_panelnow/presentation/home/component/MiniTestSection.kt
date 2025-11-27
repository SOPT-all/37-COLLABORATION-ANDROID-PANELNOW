package org.sopt.sopt_collaboration_panelnow.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray4
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.MiniTestModel
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.miniTestList

@Composable
fun MiniTestSection(
    modifier: Modifier = Modifier,
    miniTests: List<MiniTestModel> = miniTestList,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {

        Text(
            text = "미니 테스트",
            style = PanelNowTheme.typography.titleSb16,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(miniTests) { item ->
                MiniTestCard(
                    title = item.title,
                    seconds = item.seconds,
                    points = item.points
                )
            }
        }
    }
}

@Composable
fun MiniTestCard(
    modifier: Modifier = Modifier,
    title: String,
    seconds: Int,
    points: Int,
) {
        Column(
            modifier = modifier .width(250.dp)
                .height(168.dp)
                .padding(8.dp)
                .background(color = PanelNowTheme.colors.white, shape = RoundedCornerShape(20.dp)).padding(20.dp)

        ) {

            Text(
                text = "${seconds}초",
                style = PanelNowTheme.typography.titleM12,
                color = PanelNowTheme.colors.gray2
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                style = PanelNowTheme.typography.titleSb16,
            )

            Spacer(modifier = Modifier.height(20.dp))
            Spacer(modifier = Modifier.weight(1f))

            PointLabel(points = "${points}P")
        }
}

@Preview(showBackground = true)
@Composable
private fun MiniTestSectionPreview() {
    Surface(color = Gray4) {
        MiniTestSection(
            modifier = Modifier.padding(16.dp),
            miniTests = miniTestList
        )
    }
}
