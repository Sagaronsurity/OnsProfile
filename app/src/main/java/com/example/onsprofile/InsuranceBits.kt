package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BitsRow(
    onArrowClicked: () -> Unit
){

    Column {
        val pageState = rememberLazyListState()
        val currentPage = remember { derivedStateOf { pageState.firstVisibleItemIndex } }
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Insurance bits",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 14.sp,
                fontWeight = FontWeight(700),
                lineHeight = 20.sp,
                modifier = Modifier.weight(1f))
            DotsIndicator(totalDots = 3, selectedIndex = currentPage.value)

        }
        LazyRow(
            state = pageState,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
             items(3){
                 Column{
                     BitCard(
                         onArrowClicked = onArrowClicked
                     )
                     Spacer(modifier = Modifier.height(12.dp))
                     BitCard(
                         onArrowClicked = onArrowClicked
                     )
                 }
             }

        }

    }
}


@Composable
fun BitCard(
    onArrowClicked:()->Unit
){
    Card(
        modifier = Modifier
            .width(242.dp),
        shape = RoundedCornerShape(20.dp),  // Corner radius of 20dp
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F3FF)  // Background color of the card
        )
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, top = 26.dp, end = 16.dp, bottom = 26.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "What is Sum insured?",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 14.sp,
                fontWeight = FontWeight(500),
                lineHeight = 20.sp,
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable {
                        onArrowClicked()
                    }
            ){
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color(0xFF663ABF),
                    modifier = Modifier.align(Alignment.Center))
            }

        }
    }
}