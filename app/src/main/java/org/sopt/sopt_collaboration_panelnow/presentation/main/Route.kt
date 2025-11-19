package org.sopt.sopt_collaboration_panelnow.presentation.main

sealed class Route(val path: String) {
    object Survey : Route("survey")
    object Event : Route("event")
    object Home : Route("home")
    object Exchange : Route("exchange")
    object MyAction : Route("myAction")
}
