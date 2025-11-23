package org.sopt.sopt_collaboration_panelnow.presentation.home.component

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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray4
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowFontBold
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowFontRegular
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowFontSemiBold
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.MiniTestModel
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.miniTestList

@Composable
fun MiniTestCard(
    modifier: Modifier = Modifier,
    title: String,
   seconds: Int,
    points: Int,
) {
    CardSection(
        modifier = modifier
            .width(260.dp)
            .height(180.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "${seconds}초",
                fontFamily = PanelNowFontRegular,
                fontSize = 14.sp,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                fontFamily = PanelNowFontBold,
                fontSize = 18.sp,
            )

            Spacer(modifier = Modifier.weight(1f))

            PointLabel(
                points = "${points}P",
            )
        }
    }
}



@Composable
fun MiniTestSection(
    modifier: Modifier = Modifier,
    miniTests: List<MiniTestModel>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Text(
            text = "미니 테스트",
            fontFamily = PanelNowFontSemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(miniTests) { item ->
                MiniTestCard(
                    title = item.title, seconds = item.seconds,
                    points = item.points
                )
            }
        }
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
