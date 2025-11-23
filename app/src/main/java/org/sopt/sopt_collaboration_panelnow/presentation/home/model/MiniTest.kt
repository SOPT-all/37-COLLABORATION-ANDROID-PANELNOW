package org.sopt.sopt_collaboration_panelnow.presentation.home.model


data class MiniTestModel(
    val title: String,
    val seconds: Int,
    val points: Int,
)

val miniTestList = listOf(
    MiniTestModel(
        title = "겨울에도 아이스 아메리카노를 드시나요?",
        seconds = 50,
        points = 25
    ),
    MiniTestModel(
        title = "요즘 당신의 최애 간식은 무엇인가요?",
        seconds = 50,
        points = 25
    ),
    MiniTestModel(
        title = "떠나고 싶으신 곳이 있으신가요?",
        seconds = 50,
        points = 25
    )
)
