package org.sopt.sopt_collaboration_panelnow.presentation.pointdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.sopt_collaboration_panelnow.R

@Composable
fun PointImageSection(
    pointImageUrl: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            )
            .padding(horizontal = 64.dp, vertical = 44.dp),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = pointImageUrl,
            contentDescription = stringResource(id = R.string.point_detail_image),
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewPointImageSection() {
    PointImageSection(
        pointImageUrl = "https://example.com/image.jpg",
    )
}