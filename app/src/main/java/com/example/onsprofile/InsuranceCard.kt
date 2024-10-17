package com.example.onsprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun InsurenceCard(){
    Column{
        Column(
            modifier = Modifier.padding(start = 58.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(end = 4.dp, top = 4.dp)
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFFFFFFF),  // #FFFFFF
                                Color(0xFFF6F6F6)   // #F6F6F6
                            )
                        ),
                        shape = RoundedCornerShape(topEnd = 16.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "Pinelabs Pvt. Ltd.",
                    modifier = Modifier
                        .weight(1f)
                        .padding(6.dp),
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_italic)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 16.sp,
                    color = Color(0xFF5E5E62)
                )
//                Text(
//                    text = "Icici Bank",
//                    modifier = Modifier.padding(end = 8.dp, top = 4.dp, bottom = 4.dp),
//                    fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
//                    fontSize = 11.sp,
//                    fontWeight = FontWeight(500),
//                    lineHeight = 16.sp,
//                )
                Image(painter = painterResource(id = R.drawable.bankimg),
                    contentDescription = null,
                    modifier = Modifier.width(76.dp)
                        .height(19.dp)
                        .padding(end = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(
                    text = "Personal Accidental Insurance",
                    modifier = Modifier
                        .padding(start = 6.dp)
                        .weight(1f),
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 20.sp,
                    color = Color(0xFF303034)
                )
                Spacer(modifier = Modifier.width(56.dp))
                Text(
                    text = "5Lakhs",
                    modifier = Modifier
                        .padding(end = 12.dp),
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 20.sp,
                    color = Color(0xFF303034)
                )
            }
        }


        Spacer(modifier = Modifier.height(8.dp))
        Row{
            Icon(painter = painterResource(id = R.drawable.ic_3members),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.padding(start = 11.dp, top = 8.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp, top = 8.dp)
            ) {
                Text(text = "Covers",
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 16.sp,
                    color = Color(0xFF5E5E62)
                    )
                Text(text = "Self, Spouse, Children + 2 More",
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 16.sp,
                    color = Color(0xFF303034)
                )
            }
            Icon(painter = painterResource(id = R.drawable.ic_health_insurance2),
                contentDescription = null,
                tint = Color.Unspecified)

        }
    }
}


@Preview(showBackground = true)
@Composable
fun InsuranceBox(){
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFB3DBFE), Color(0xFFF2F9FF)),
                    start = Offset(0f, 0f),
                    end = Offset(100f, 160f) // This can be adjusted for the midpoint
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ) {

        CustomShapeFilled()
        Icon(painter = painterResource(id = R.drawable.ic_health_insurance),
            contentDescription = null,
            tint = Color(0xFF0156FC),
            modifier = Modifier.padding(start = 14.dp, top = 14.dp))
        InsurenceCard()

    }
}


