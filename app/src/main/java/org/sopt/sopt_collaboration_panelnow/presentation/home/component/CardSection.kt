package org.sopt.sopt_collaboration_panelnow.presentation.home.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.Gray4
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.White

@Composable
fun CardSection(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        color = White,
        tonalElevation = 10.dp,
        shadowElevation = 2.dp
    ) {
        Box(modifier = Modifier.padding(25.dp)) {
            content()
        }
    }
}

@Preview("CardSectionPreview")
@Composable
private fun CardSectionPreview() {
    Surface(color = Gray4) {
        CardSection(
            modifier = Modifier.padding(20.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {}
        }
    }
}
