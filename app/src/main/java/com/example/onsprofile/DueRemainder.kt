package com.example.onsprofile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun DueRemainder(
    onPayNowClicked : () -> Unit
){
    Card(
        colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFF9E7)
        ),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp, top = 10.dp, bottom = 10.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(painter = painterResource(id = R.drawable.ic_payment),
                contentDescription = null,
                tint = Color.Unspecified,
            )
            Text(text = "Your bill is due on ",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                lineHeight = 16.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
            Text(text = "12 Jan 2024",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 12.sp,
                fontWeight = FontWeight(700),
                lineHeight = 16.sp,)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Pay Now",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 12.sp,
                fontWeight = FontWeight(700),
                lineHeight = 16.sp,
                color = Color(0xFF0188FC),
                modifier = Modifier.clickable { onPayNowClicked() }
            )
        }
    }
}