package org.sopt.sopt_collaboration_panelnow.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray1
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray2
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray3
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray4
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.White
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.PopularSurveyModel
import org.sopt.sopt_collaboration_panelnow.presentation.home.model.popularSurveyList

@Composable
fun PopularSurveySection(
    modifier: Modifier = Modifier,
    surveys: List<PopularSurveyModel> = popularSurveyList,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "인기 설문",
                style = PanelNowTheme.typography.titleSb16,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "전체보기",
                style = PanelNowTheme.typography.bodyR14,
                color = Gray2
            )

            Spacer(modifier = Modifier.width(12.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = "arrow_right",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(14.5.dp))

        Surface(
            modifier = Modifier.fillMaxWidth(), color = White,
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 8.dp
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                surveys.forEach { survey ->
                    PopularSurveyCard(
                        survey = survey
                    )
                }
            }

        }
    }
}

@Composable
private fun PopularSurveyCard(
    survey: PopularSurveyModel
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(56.dp)
                .background(
                    color = Gray3,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = survey.iconRes),
                contentDescription = survey.title,
                tint = Color.Unspecified,
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = survey.title,
                style = PanelNowTheme.typography.titleSb16
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${survey.minutes}분",
                style = PanelNowTheme.typography.bodyM12,
                color = Gray1
            )

        }

        PointLabel(
            points = "${survey.points}P"
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PopularSurveySectionPreview() {
    Surface(color = Gray4) {
        PopularSurveySection(
            modifier = Modifier.padding(10.dp)
        )
    }
}
