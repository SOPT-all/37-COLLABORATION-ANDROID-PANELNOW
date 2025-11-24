package org.sopt.sopt_collaboration_panelnow.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.SOPT_COLLABORATION_PANELNOWTheme
import org.sopt.sopt_collaboration_panelnow.presentation.main.navigation.CustomNavigator

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SOPT_COLLABORATION_PANELNOWTheme {
                CustomNavigator()
            }
        }
    }
}
