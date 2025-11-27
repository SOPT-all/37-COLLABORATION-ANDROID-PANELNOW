package org.sopt.sopt_collaboration_panelnow.presentation.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(
            topStart = 15.dp,
            topEnd = 999.dp,
            bottomEnd = 999.dp,
            bottomStart = 0.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = PanelNowTheme.colors.mainBlue,
            contentColor =  PanelNowTheme.colors.white
        )
    ) {
        Text(
            text = text,
            style = PanelNowTheme.typography.bodyR16
        )
    }
}

@Preview("ButtonPreview")
@Composable
private fun CustomButtonPreview() {
    Surface(color = PanelNowTheme.colors.gray4) {
        CustomButton(onClick = {}, modifier = Modifier, text = "교환하기")
    }
}
