package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

val Pages = mutableListOf(
    PlanCardData("Onyx", 1, 1, false, 100),
    PlanCardData("Jade", 5, 2, true, 200),
    PlanCardData("Ruby", 3, 2, false, 150)
)


@Composable
fun PlanSelection() {
    val pagerState = rememberPagerState(initialPage = 1) { Pages.size }
    HorizontalPager(
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 85.dp),
        modifier = Modifier
            .padding(top = 200.dp)
            .background(color = Color(0xFFF2F9FF))
            .height(500.dp)
            .fillMaxWidth()
    ) { page ->
        val pageOffset = pagerState.getOffsetDistanceInPages(page)
        PlanCard(data = Pages[page],pageOffset)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlanSelection() {
    PlanSelection()
}
