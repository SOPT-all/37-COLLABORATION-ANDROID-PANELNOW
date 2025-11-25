package org.sopt.sopt_collaboration_panelnow.presentation.home.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.presentation.home.component.MiniTestSection
import org.sopt.sopt_collaboration_panelnow.presentation.home.component.PointTransactionsSection
import org.sopt.sopt_collaboration_panelnow.presentation.home.component.PopularSurveySection
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.MiniTestModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    pointsText: String = "4,500P",
    miniTests: List<MiniTestModel>,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
//            .padding(top = 16.dp, bottom = 16.dp)
    ) {

        PointTransactionsSection(
            modifier = Modifier.fillMaxWidth(),
            pointsText = pointsText
        )
        Spacer(modifier = Modifier.height(24.dp))

        PopularSurveySection(
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        MiniTestSection(
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
            ,
            miniTests = miniTests
        )

    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    val miniTests = listOf(
        MiniTestModel("겨울에도 아이스 아메리카노를 드시나요?", seconds = 50, points = 25),
        MiniTestModel("요즘 당신의 최애 간식은 무엇인가요?", seconds = 50, points = 25),
        MiniTestModel("떠나고 싶으신 곳이 있으신가요?", seconds = 50, points = 25),
    )

    HomeScreen(
        pointsText = "4,500P",
        miniTests = miniTests
    )
}
