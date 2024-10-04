package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun NomineeRemainders(
    onMemberAdditionClicked : () -> Unit = {}
) {
    val pagerState = rememberPagerState(initialPage = 0){3}

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFFFF9E7))
    ) {
        Row(
            modifier = Modifier.width(280.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 16.dp),
                pageSpacing = 16.dp,
            ) { page ->
                NomineeRemainderCard()
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .background(color = Color(0xFFFFF9E7))
                .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 10.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                text = "View Details",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF0188FC),
                modifier = Modifier.clickable { onMemberAdditionClicked() }
            )
            Spacer(modifier = Modifier.height(30.dp))
            DotsIndicator(totalDots = 3, selectedIndex = pagerState.currentPage)
        }
    }
}


@Composable
fun NomineeRemainderCard(){
    Row(
        modifier = Modifier
            .background(color = Color(0xFFFFF9E7))
            .padding(top = 10.dp, end = 16.dp, bottom = 10.dp)
    ){
        Icon(painter = painterResource(id = R.drawable.ic_clock),
            tint = Color.Unspecified,
            contentDescription = null)
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(text = "Clock is Ticking !",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFFAA711C)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "17 days left to add members to your \n" +
                    " Swiggy Pvt. Ltd. membership.",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400)
                )
        }
    }
}