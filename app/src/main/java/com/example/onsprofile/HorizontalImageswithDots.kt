package com.example.onsprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ImageCarouselWithDots() {
    val images : List<Int> = listOf(
        R.drawable.banner,
        R.drawable.banner,
        R.drawable.banner
    )

    val pagerState = rememberPagerState(initialPage = 0){ images.size }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Image pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
        ) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .height(80.dp)
                    .width(328.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Dots indicator
        DotsIndicator(
            totalDots = images.size,
            selectedIndex = pagerState.currentPage
        )
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    horizontalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until totalDots) {
            val isSelected = i == selectedIndex
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .clip(if (isSelected) RoundedCornerShape(50) else CircleShape)
                    .size(
                        if (isSelected) 14.dp else 4.dp,
                        height = 4.dp
                    )
                    .background(if (isSelected) Color(0xFF0188FC) else Color(0xFFE2E3E6))
            )
        }
    }
}
