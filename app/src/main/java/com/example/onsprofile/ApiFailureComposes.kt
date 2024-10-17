package com.example.onsprofile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun ListApiFailuer(){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_awaiting),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Oops! Something didn’t load right.",
            fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
            fontSize = 16.sp,
            fontWeight = FontWeight(700),
            lineHeight = 28.sp,
            color = Color(0xFF303034)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Looks like we had trouble fetching your data.",
            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
            fontSize = 11.sp,
            fontWeight = FontWeight(500),
            lineHeight = 16.sp,
            color = Color(0xFF5E5E62)
        )
        Text(text = "Please Retry!",
            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
            fontSize = 11.sp,
            fontWeight = FontWeight(500),
            lineHeight = 16.sp,
            color = Color(0xFF5E5E62)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0188FC),
                contentColor = Color.White
            )
        ) {
            Text(
                "Retry",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 12.sp,
                fontWeight = FontWeight(700),
                lineHeight = 16.sp,
                modifier = Modifier.padding(start = 40.dp, end = 40.dp)
            )
        }
    }
}