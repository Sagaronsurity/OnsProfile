package com.example.onsprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
                    .padding(8.dp)
                    .height(108.dp)
                    .width(108.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )

            CircularProgressIndicator(
                progress = { 1f },
                color = Color(0XFF1C68F0),
                strokeWidth = 6.dp,
                modifier = Modifier
                    .padding(1.dp)
                    .width(120.dp)
                    .height(120.dp)
            )


            CircularProgressIndicator(
                progress = { progress.toFloat() },
                color = if (progress < 1.0) Color(0xFFFDDE13) else Color(
                    0xFF13FD55
                ),
                strokeWidth = 6.dp,
                modifier = Modifier
                    .padding(top = 1.dp, start = 1.dp)
                    .width(120.dp)
                    .height(120.dp)
            )



            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF002042), shape = CircleShape)
                        .padding(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CameraAlt, contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(4.dp)
                    )
                }
            }

        }
        Text(
            text = "${progress * 100}".replace(".0", "%"),
            color = Color.White,
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = "Profile Completion",
            color = Color(0xFFC7C6CA),
            style = MaterialTheme.typography.bodyMedium
        )


    }
}