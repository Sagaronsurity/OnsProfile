package com.example.onsprofile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onsprofile.ui.theme.OnsProfileTheme

@Preview
@Composable
fun PreviewProfile(){
      ProfileScreen(onBackClick = {},
          profiledata = profiledata("Santhosh Mangaldeep", "Male", "02 Oct 2002", "9876543210", 1.0),
          onItemClick = {}
      )
}
@Composable
fun ProfileScreen(onBackClick: () -> Unit, profiledata: profiledata , onItemClick: (String) -> Unit) {

    Scaffold(
        bottomBar = { BottomBar() }
    ) {
        Profile(modifier = Modifier.padding(it), onBackClick, profiledata , onItemClick )
    }

}

@Composable
fun BottomBarItem(icon: Int, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 23.dp, end = 23.dp,top = 13.dp)
    ) {

            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.clickable {  }
            )

        Text(text = label,
            color = Color(0xFFC7C6CA),
            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
            fontSize = 10.sp,
            lineHeight = 13.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(bottom = 12.dp, top = 3.dp)
        )
    }
}

@Composable
fun BottomBar() {
    val items = listOf(
        mapOf("icon" to R.drawable.ic_home, "label" to "Home"),
        mapOf("icon" to R.drawable.ic_insurence, "label" to "Insurance"),
        mapOf("icon" to R.drawable.ic_love, "label" to "Wellness"),
        mapOf("icon" to R.drawable.ic_profile, "label" to "Profile")
    )
    Row(
        modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .background(Color.Black,
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items.forEach { item ->
                BottomBarItem(
                    icon = item["icon"] as Int,
                    label = item["label"] as String
                )
            }
        }
}



@Composable
fun Profile(modifier: Modifier, onBackClick: () -> Unit, profiledata: profiledata , onItemClick: (String) -> Unit) {
    OnsProfileTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF101869),
                            Color(0xFF0715C0),
                            Color(0xFF1F76F8)
                        ),
                        radius = 700f,
                        center = Offset(
                            x = -0.0319f * 1000f,  // -3.19% of the width
                            y = 0.0f               // 0% of the height
                        )
                    )
                )
        ) {
            Column {
                Row(
                    Modifier
                        .padding(top = 36.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_onslogo),
                        contentDescription = null,

                        )

                    Row(
                        Modifier.weight(1f),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_notification),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable {  }
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.ic_cart),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable {  }
                                .padding(start = 24.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_headset),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable {  }
                                .padding(start = 24.dp)
                        )
                    }
                }
                Profiledetails(onBackClick, profiledata)
                ListItemsColoumn(onItemClick)
            }
        }
    }
}


@Composable
fun Profiledetails(onBackClick: () -> Unit, profiledata: profiledata) {

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = profiledata.name, color = Color.White,
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 19.sp
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(35.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "Gender",
                            color = Color(0xFF93ADF4),
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(300),
                            lineHeight = 13.sp
                        )
                        Text(text = profiledata.gender,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            lineHeight = 20.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "DoB",
                            color = Color(0xFF93ADF4),
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(300),
                            lineHeight = 13.sp
                        )
                        Text(text = profiledata.dob,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            lineHeight = 20.sp)
                    }

                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Phone Number",
                        color = Color(0xFF93ADF4),
                        fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(300),
                        lineHeight = 13.sp
                    )
                    Text(text = profiledata.phnNumber,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 20.sp)
                }
                if (profiledata.profileProgress == 1.0) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable { onBackClick() }

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_pen),
                            contentDescription = null
                        )
                        Text(
                            text = "Edit",
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                            fontSize = 14.sp,
                            fontWeight = FontWeight(700),
                            lineHeight = 17.sp,
                            color = Color.White,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }

            ProfileCard(progress = profiledata.profileProgress.toFloat())
        }

        if (profiledata.profileProgress < 1) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.linearGradient(
                            listOf(Color(0xFF001769), Color(0xFF1D1D1D))
                        )
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(32.dp),
                    modifier = Modifier.padding(12.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 8.dp)

                    ) {
                        Image(
                            painter = painterResource(R.drawable.ic_red1),
                            contentDescription = null
                        )
                        Text(
                            text = "Please fill nominee and email ID\n to complete profile",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                            lineHeight = 14.sp,
                            fontWeight = FontWeight(400)
                        )
                    }
                    TextButton(
                        onClick = { onBackClick() },
                        ) {
                        Text(
                            text = "Edit Profile",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF1987FB),
                            )
                    }

                }
            }
        }
    }
}


@Composable
fun Listitem(name: String, id: Int , onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.padding(start = 8.dp, end = 16.dp, top = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = id),
                contentDescription = null,
                tint = Color(0xFF5E5E62)
            )
            Text(
                text = name,
                color = Color(0xFF303034),
                fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = Color(0xFFC7C6CA),
                modifier = Modifier.clickable { onClick(name) }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        HorizontalDivider(
            color = Color(0xFFEBEBEB),
            thickness = 2.dp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )

    }
}

@Composable
fun ListItemsColoumn(onItemClick : (String)->Unit) {

    val items = mutableListOf(
        "Company Plan" to R.drawable.ic_companyplan,
        "Family Members" to R.drawable.ic_familymembers,
        "Memberships" to R.drawable.ic_memberships,
        "Claim history" to R.drawable.ic_claimhistory,
        "Billing" to R.drawable.ic_billings,
        "Orders" to R.drawable.ic_orders,
        "Autopay" to R.drawable.ic_autopay,
        "Support" to R.drawable.ic_headset,
        "Settings" to R.drawable.ic_settings,
    )
    var count = 0
    LazyColumn(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(color = Color.White)
            .padding(top = 32.dp)
    ) {
        items(items) { item ->
            count++
            Listitem(name = item.first, id = item.second , onItemClick )
            if(count==items.size){
                Spacer(modifier = Modifier.height(70.dp))
            }
        }

    }
}

