package org.sopt.sopt_collaboration_panelnow.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PanelNowTheme {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = true

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color.White,
                        darkIcons = useDarkIcons
                    )
                    systemUiController.setNavigationBarColor(
                        color = Color.White,
                        darkIcons = useDarkIcons
                    )
                }

                MainScreen()
            }
        }
    }
}
