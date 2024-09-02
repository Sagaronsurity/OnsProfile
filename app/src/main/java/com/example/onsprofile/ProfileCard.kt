package com.example.onsprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileCard(progress : Float){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(end = 8.dp)
    ) {

        Box(

        ) {
            Image(
                painter = painterResource(id = R.drawable.profileforons),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.Center)
            )

            CircularProgressIndicator(
                progress = { 1f },
                color = Color(0XFF1C68F0),
                strokeWidth = 6.dp,
                modifier = Modifier

                    .width(102.dp)
                    .height(102.dp)
                    .align(Alignment.Center)
            )


            CircularProgressIndicator(
                progress = { progress },
                color = if (progress < 1.0) Color(0xFFFDDE13) else Color(
                    0xFF13FD55
                ),
                strokeWidth = 6.dp,
                modifier = Modifier

                    .width(102.dp)
                    .height(102.dp)
                    .align(Alignment.Center)
            )



            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(5.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_cam),
                    contentDescription = null,
                    tint = Color.Unspecified)
            }

        }
        Row {
//            Icon(painter = painterResource(id = R.drawable.ic_flash), contentDescription = null, tint = Color.Unspecified)
            Text(
                text = "${progress * 100}".replace(".0", "%"),
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                fontSize = 14.sp,
                fontWeight = FontWeight(700),
                lineHeight = 17.sp
            )
        }


        Text(
            text = "Profile Completion",
            color = Color(0xFFC7C6CA),
            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            lineHeight = 16.sp
        )


    }
}