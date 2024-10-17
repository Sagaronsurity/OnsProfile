package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun BenifitsFAB(){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .size(height = 48.dp, width = 120.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF00172A),
                        Color(0xFF001728)
                    )
                ),
                shape = RoundedCornerShape(32.dp)
            )
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF219BE0),
                        Color(0xFF1E19FB)
                    )
                ),
                shape = RoundedCornerShape(32.dp)
            )
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_flash_bg),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(
                    start = 16.dp, top = 1.dp
                )
                .blur(
                    6.dp
                )
        )
        Icon(painter = painterResource(id = R.drawable.ic_flasher),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.padding(
                start = 23.dp, top = 14.dp
            )
        )
        Icon(painter = painterResource(id = R.drawable.ic_light_grid),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.align(
                Alignment.BottomEnd
            )
                .scale(1.5f)
                .offset(x = -4.dp, y = -8.dp)
        )
        Column(
            modifier = Modifier.padding(
                start = 53.dp, top = 8.dp
            )
        ) {
            Text(
                text = "RAISE",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 11.sp,
                fontWeight = FontWeight(500),
                color = Color.White,
            )
            Text(
                text = "CLAIM",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 14.sp,
                fontWeight = FontWeight(700),
                color = Color.White,
            )
        }

    }
}