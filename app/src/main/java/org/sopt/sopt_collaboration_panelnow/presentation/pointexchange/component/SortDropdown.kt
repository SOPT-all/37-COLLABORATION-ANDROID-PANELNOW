package org.sopt.sopt_collaboration_panelnow.presentation.pointexchange.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.sopt_collaboration_panelnow.core.designsystem.theme.PanelNowTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import org.sopt.sopt_collaboration_panelnow.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SortDropdown(
    selectedSort: String,
    onSortSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    val labelMap = mapOf(
        "default" to "인기순",
        "price_asc" to "가격 낮은순",
        "price_desc" to "가격 높은순",
    )

    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(PanelNowTheme.colors.white)
                .border(
                    width = 1.dp,
                    color = PanelNowTheme.colors.gray1,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable { expanded = true },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = labelMap[selectedSort] ?: "인기순",
                style = PanelNowTheme.typography.titleM14,
                color = PanelNowTheme.colors.gray6,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_dropdown),
                contentDescription = "arrow",
                tint = PanelNowTheme.colors.gray6,
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = PanelNowTheme.colors.gray1,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(
                    color = PanelNowTheme.colors.white,
                    shape = RoundedCornerShape(20.dp)
                ),
        ) {
            DropdownMenuItem(
                text = { Text("인기순") },
                onClick = {
                    expanded = false
                    onSortSelected("default")
                },
            )
            DropdownMenuItem(
                text = { Text("가격 낮은순") },
                onClick = {
                    expanded = false
                    onSortSelected("price_asc")
                },
            )
            DropdownMenuItem(
                text = { Text("가격 높은순") },
                onClick = {
                    expanded = false
                    onSortSelected("price_desc")
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SortDropdownPreview() {
    PanelNowTheme {
        SortDropdown(
            selectedSort = "default",
            onSortSelected = {}
        )
    }
}
