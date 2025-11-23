package org.sopt.sopt_collaboration_panelnow.presentation

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
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import org.sopt.sopt_collaboration_panelnow.R

@Composable
fun PanelNowTopBar(
    title: String? = null,
    showLogo: Boolean = false,
    onAlarmClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showLogo) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "PanelNow Logo",
                modifier = Modifier.height(32.dp)
            )
        } else {
            Text(
                text = title.orEmpty(),
                style = PanelNowTheme.typography.titleSb16,
                color = PanelNowTheme.colors.gray6
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_topbar_alert),
                contentDescription = "Alarm",
                modifier = Modifier
                    .size(24.dp)
                    .clickable{ onAlarmClick() }
            )
            Image(
                painter = painterResource(id = R.drawable.ic_topbar_user),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(24.dp)
                    .clickable{ onProfileClick() }
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun PanelNowTopBarPreview_logo() {
    PanelNowTheme {
        PanelNowTopBar(
            showLogo = true
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun PanelNowTopBarPreview_text() {
    PanelNowTheme {
        PanelNowTopBar(
            title = "포인트 교환",
            showLogo = false
        )
    }
}
