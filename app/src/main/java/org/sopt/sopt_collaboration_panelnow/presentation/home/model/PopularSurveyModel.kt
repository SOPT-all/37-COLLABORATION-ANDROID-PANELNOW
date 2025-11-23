package org.sopt.sopt_collaboration_panelnow.presentation.home.model

import androidx.annotation.DrawableRes
import org.sopt.sopt_collaboration_panelnow.R

data class PopularSurveyModel(val title: String, val minutes :Int, val points : Int, @DrawableRes val iconRes : Int)

val popularSurveyPreviewList = listOf(
    PopularSurveyModel(

        title = "블랙프라이데이 쇼핑 경험",
      minutes = 1,
       points = 100,
        iconRes = R.drawable.ic_point_card
    ),
    PopularSurveyModel(

        title = "운동을 즐겨 하시나요?",
        minutes = 15,
        points = 230,
        iconRes = R.drawable.ic_point_exercise
    ),
    PopularSurveyModel(

        title = "어느 지역에서 생활하시나요?",
        minutes = 23,
        points = 500,
        iconRes= R.drawable.ic_point_map),
)
