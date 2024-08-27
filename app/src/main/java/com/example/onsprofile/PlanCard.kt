package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import kotlin.math.abs
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onsprofile.ui.theme.hkGroteskFontFamily
import kotlin.math.absoluteValue


@Composable
fun InsDiscription(
    name : String,
    Amt : Int,
    Icon : Int,
    pageOffset: Float
){
    Row(
        modifier = Modifier.padding((8-abs(pageOffset*5)).dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
         Icon(painter = painterResource(id = Icon),
             contentDescription = null,
             tint = Color.Unspecified)
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF5E5E62)
                )
            ){
                append(name+"\n")
            }
            if(Amt > 0){
                withStyle(
                    style = SpanStyle(
                        fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF5E5E62)
                    )
                ){
                    append("Sum Insured")
                }
                withStyle(
                    style = SpanStyle(
                        fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF5E5E62)
                    )
                ){
                    append("  ${Amt} Lakhs")
                }
            }
            else{
                withStyle(
                    style = SpanStyle(
                        fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400)
                    )
                ){
                    append("Lab Tests, Doctor\nConsultaion...+ 3 More")
                }
            }


        })
    }
}

@Preview
@Composable
fun Recomended(){
    Box(
        modifier = Modifier
            .background(
                Color(0xFF2A982F),
                shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
            )
            .padding(1.dp)
    ) {
        Text(
            text = "RECOMENDED",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
            fontSize = 11.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
    }
}


@Composable
fun BodyofCard(
    PlanName : String,
    PlanAmt : Int,
    HealthAmt : Int,
    PAAmt : Int,
    pageOffset: Float
){

    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 16.dp, bottom = 20.dp, end = 20.dp)
            .width(216.dp)
    ) {

        Text(
            text = "Upgrade To",
            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
            fontSize = 11.sp,
            fontWeight = FontWeight(500),
            lineHeight = 16.sp,
            color = Color(0xFFC7C6CA)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = PlanName,
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 22.sp,
                fontWeight = FontWeight(700),
                lineHeight = 28.sp,
                color = Color(0xFF14715A)
            )
            Icon(painter = painterResource(id = R.drawable.ic_ibutton), contentDescription = null)
        }
        Spacer(modifier = Modifier.height((12-abs(pageOffset*5)).dp))
        HorizontalDivider(
            thickness = 1.dp,
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFE2E3E6),
                            Color(0xFFFFFFFF)
                        )
                    )
                )
        )
        InsDiscription(name = "Health Insurance", Amt = HealthAmt, Icon = R.drawable.ic_health_insurance, pageOffset = pageOffset )
        InsDiscription(name = "Accidental Insurance", Amt = PAAmt, Icon = R.drawable.ic_pa,pageOffset = pageOffset)
        InsDiscription(name = "Wellness Benefits", Amt = 0, Icon = R.drawable.ic_wellness, pageOffset = pageOffset)

        Spacer(modifier = Modifier.height((19-abs(pageOffset*7)).dp))
        Text(
            text = "You Pay",
            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
            fontSize = 11.sp,
            fontWeight = FontWeight(500),
            lineHeight = 16.sp,
            color = Color(0xFFC7C6CA)
        )
        Text(
            text = "₹${PlanAmt}/month",
            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
            fontSize = 18.sp,
            fontWeight = FontWeight(400),
            lineHeight = 24.sp,
            color = Color(0xFF303034)
        )
    }

}

@Composable
fun PlanCard(
    data: PlanCardData,
    pageOffset : Float
){
    var is_selected by remember { mutableStateOf(false) }

    Column(
    ) {
        Spacer(modifier = Modifier.height(if(pageOffset > 0) (pageOffset*34).dp else abs(pageOffset*11).dp))
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    brush = if (is_selected) {
                        Brush.linearGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xFF2A982F),
                                Color(0xFF2A982F),
                                Color.Transparent,
                            ),
                        )
                    } else {
                        Brush.linearGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Color.Transparent,
                                Color.Transparent,
                            )
                        )
                    },
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            if (data.Recommended) {
                Recomended()
            }

            if (is_selected) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(id = R.drawable.ic_right_pattern),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Icon(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(id = R.drawable.ic_left_pattern),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

            }
            IconButton(
                onClick = { is_selected = !is_selected },
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    modifier = Modifier
                        .padding(6.dp),
                    painter = painterResource(
                        id =
                        if (is_selected) R.drawable.ic_checked else R.drawable.ic_unchecked
                    ),
                    contentDescription = null,
                    tint = Color.Unspecified
                )

            }
            BodyofCard(
                PlanName = data.Name,
                PlanAmt = data.Price,
                HealthAmt = data.HealthInc,
                PAAmt = data.AccidentalInc,
                pageOffset = pageOffset
            )
        }
    }

}
@Preview
@Composable
fun CardPreview(){
    PlanCard(data = PlanCardData("Jade",5,2,true,200),.0f)
}