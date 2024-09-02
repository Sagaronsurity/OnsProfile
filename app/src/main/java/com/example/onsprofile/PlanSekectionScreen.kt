package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CurrentPlanCard(
    isCurrentPlanSelected: Boolean,
    onCurrentPlanSelected: (Boolean) -> Unit
) {
        Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CustomShape(cornerRadius = 12.dp))
                    .background(
                        color = Color.White,
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFFF2F2F2),
                        shape = CustomShape(12.dp)
                    )
        ) {
                Text(
                    text = "CURRENT PLAN",
                    modifier = Modifier
                        .padding(start = 12.dp, top = 4.dp, end = 12.dp),
                    color = Color(0xFF5E5E62),
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                    fontSize = 11.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500),
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(
                        top = 9.dp,
                        start = 12.dp,
                        end = 6.dp
                    )
                ) {
                    Text(
                        text = "OPAL",
                        color = Color(0xFF713DC5),
                        fontFamily = FontFamily(Font(R.font.hk_grotesk_semi_bold)),
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(700),
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_ibutton),
                        contentDescription = null,
                        tint = Color(0xFF713DC5),
                        modifier = Modifier
                            .padding(start = 2.dp)
                            .clickable { onCurrentPlanSelected(!isCurrentPlanSelected) }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "₹0/month",
                        color = Color(0xFF5E5E62),
                        fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                    )
                    Icon(
                        painter = painterResource(id = if (isCurrentPlanSelected) R.drawable.ic_checked else R.drawable.ic_unchecked),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { onCurrentPlanSelected(true) }
                            .padding(start = 8.dp),
                        tint = Color.Unspecified
                    )
                }
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xFFE2E3E6),
                    modifier = Modifier.padding(top = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text(
                            text = "Health Insurance",
                            color = Color(0xFF303034),
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 11.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(500),
                        )
                        Text(
                            text = "2 Lakhs",
                            color = Color(0xFF5E5E62),
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(400),
                        )
                    }
                    VerticalDivider(
                        thickness = 1.dp,
                        color = Color(0xFFE2E3E6),
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp)
                            .height(34.dp)
                    )
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text(
                            text = "Accidental Ins...",
                            color = Color(0xFF303034),
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 11.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(500),
                        )
                        Text(
                            text = "1 Lakhs",
                            color = Color(0xFF5E5E62),
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(400),
                        )
                    }
                    VerticalDivider(
                        thickness = 1.dp,
                        color = Color(0xFFE2E3E6),
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp)
                            .height(34.dp)
                    )
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text(
                            text = "Wellness Bene...",
                            color = Color(0xFF303034),
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 11.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(500),
                        )
                        Text(
                            text = "4 Benefits",
                            color = Color(0xFF5E5E62),
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(400),
                        )
                    }
                }
            }
}

val Pages = mutableListOf(
    PlanCardData("Onyx", 1, 1, false, 100),
    PlanCardData("Jade", 5, 2, true, 200),
    PlanCardData("Ruby", 3, 2, false, 150)
)


@Composable
fun PlanSelection(
    selectedPage: Int,
    onPageSelected: (Int) -> Unit
) {
    val pagerState = rememberPagerState(initialPage = 1) { Pages.size }

    HorizontalPager(
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 85.dp),
        modifier = Modifier
            .background(color = Color(0xFFF2F9FF))
            .padding(top = 28.dp, bottom = 28.dp)
            .fillMaxWidth()
    ) { page ->
        val pageOffset = pagerState.getOffsetDistanceInPages(page)
        PlanCard(
            data = Pages[page],
            pageOffset,
            is_selected = selectedPage == page,
            onCardSelected = { onPageSelected(page) }
        )
    }
}

@Composable
@Preview
fun PlanSelectionScreen() {
    var isCurrentPlanSelected by remember { mutableStateOf(true) }
    var selectedPage by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .background(color = Color(0xFFF2F9FF))
            .padding(top = 200.dp)
    ) {
        CurrentPlanCard(
            isCurrentPlanSelected = isCurrentPlanSelected,
            onCurrentPlanSelected = { isSelected ->
                isCurrentPlanSelected = isSelected
                if (isSelected) selectedPage = -1
            }
        )
        PlanSelection(
            selectedPage = selectedPage,
            onPageSelected = { page ->
                selectedPage = page
                isCurrentPlanSelected = false
            }
        )
    }
}




