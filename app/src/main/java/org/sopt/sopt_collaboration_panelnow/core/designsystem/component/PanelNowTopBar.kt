package org.sopt.sopt_collaboration_panelnow.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import org.sopt.sopt_collaboration_panelnow.R
import org.sopt.sopt_collaboration_panelnow.core.common.extension.noRippleClickable

@Composable
fun PanelNowTopBar(
    content: @Composable () -> Unit,
    modifier : Modifier = Modifier,
    onAlarmClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(PanelNowTheme.colors.gray4)
            .padding(WindowInsets.statusBars.asPaddingValues())
            .height(56.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_topbar_alert),
                contentDescription = stringResource(id = R.string.top_bar_alarm),
                tint = PanelNowTheme.colors.mainBlue,
                modifier = Modifier.noRippleClickable(onClick = onAlarmClick)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_topbar_user),
                contentDescription = stringResource(R.string.top_bar_profile),
                tint = PanelNowTheme.colors.mainBlue,
                modifier = Modifier.noRippleClickable(onClick = onProfileClick)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PanelNowTopBarPreview_logo() {
    PanelNowTheme {
        PanelNowTopBar(
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(R.string.top_bar_logo),
                    tint = Color.Unspecified,
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PanelNowTopBarPreview_text() {
    PanelNowTheme {
        PanelNowTopBar(
            content = {
                Text(
                    text = "포인트 교환",
                    style = PanelNowTheme.typography.titleSb16,
                    color = PanelNowTheme.colors.gray6
                )
            }
        )
    }
}
