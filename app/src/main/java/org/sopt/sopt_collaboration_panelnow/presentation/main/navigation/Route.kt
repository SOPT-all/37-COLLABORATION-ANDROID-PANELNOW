package org.sopt.sopt_collaboration_panelnow.presentation.main.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route

@Serializable
data object Home : Route

@Serializable
data object Survey : Route

@Serializable
data object Event : Route

@Serializable
data object Exchange : Route

@Serializable
data object MyAction : Route
