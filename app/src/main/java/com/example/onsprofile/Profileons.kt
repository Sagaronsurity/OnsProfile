package com.example.onsprofile

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onsprofile.ui.theme.OnsProfileTheme
import kotlinx.serialization.Serializable


@Serializable
object profile


@Serializable
object form


@Composable
fun NavController(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = profile ) {

        composable<profile> {

            ProfileScreen({navController.navigate(form)},profiledata("Santhosh Mangaldeep","Male","02 Oct 2002","9876543210",1.0))
        }
        composable<form> { Form { navController.navigate(profile) }  }

    }

}


@Composable
fun ProfileScreen(onBackClick : ()->Unit, profiledata: profiledata){

    Scaffold(
        bottomBar ={ Buttombar() }
    ){
            Profile(modifier = Modifier.padding(it), onBackClick,profiledata)
    }

}


@Composable
fun Buttombar(){

    Surface(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topStart = 24.dp, topEnd = 32.dp))

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
                Text(text = "Home", color = Color(0xFFC7C6CA))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_insurence),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
                Text(text = "Insurence", color = Color(0xFFC7C6CA))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_wellness),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
                Text(text = "Wellness", color = Color(0xFFC7C6CA))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
                Text(text = "Profile", color = Color(0xFFC7C6CA))
            }

        }
    }
}

@Composable
fun Profile(modifier: Modifier,onBackClick: () -> Unit,profiledata: profiledata){
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
        ){
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
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_notification),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_cart),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_headset),
                                contentDescription = null,
                                tint = Color.Unspecified
                            )
                        }
                    }
                }


                Profiledetails(onBackClick,profiledata)
                ListItemsColoumn()

            }
        }


    }
}


@Composable
fun Profiledetails(onBackClick: () -> Unit,profiledata: profiledata){

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
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = profiledata.name, color = Color.White,
                    style = MaterialTheme.typography.displayLarge
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "Gender", color = Color(0xFF93ADF4),style = MaterialTheme.typography.bodyMedium,)
                        Text(text = profiledata.gender, color = Color.White)
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "DoB", color = Color(0xFF93ADF4),style = MaterialTheme.typography.bodyMedium)
                        Text(text = profiledata.dob, color = Color.White)
                    }

                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(text = "PhoneNumber", color = Color(0xFF93ADF4),style = MaterialTheme.typography.bodyMedium)
                    Text(text = profiledata.phnNumber, color = Color.White)
                }
                if(profiledata.profileProgress == 1.0){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,

                            ){
                            Image(painter = painterResource(id = R.drawable.ic_pen), contentDescription = null)
                            TextButton(
                                onClick = { onBackClick },
                            ){ Text(text = "Edit",
                                style = MaterialTheme.typography.displayLarge,
                                color = Color.White,


                                )
                            }
                    }
                }

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(end = 8.dp)
            ) {

                Box(

                ) {
                    Image(painter = painterResource(id = R.drawable.profileforons),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .height(108.dp)
                            .width(108.dp)
                            .clip(CircleShape)
                            .background(Color.White))

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
                        progress = { profiledata.profileProgress.toFloat() },
                        color = if(profiledata.profileProgress < 1.0)  Color(0xFFFDDE13) else Color(0xFF13FD55),
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
                        Box(modifier = Modifier
                            .background(Color(0xFF002042), shape = CircleShape)
                            .padding(4.dp)
                        ){
                            Icon(imageVector = Icons.Default.CameraAlt, contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(4.dp))
                        }
                    }

                }
//                Image(painter = painterResource(id = R.drawable.ic_flash), contentDescription = null)
                Text(text = "${profiledata.profileProgress*100}".replace(".0","%"), color = Color.White,style = MaterialTheme.typography.displayLarge)
                Text(text = "Profile Completion", color = Color(0xFF93ADF4),style = MaterialTheme.typography.bodyMedium)


            }

        }

        if(profiledata.profileProgress < 1){
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
                        Image(painter = painterResource(R.drawable.ic_red1), contentDescription = null)
                        Text(text = "Please fill nominee and email ID\n to complete profile",
                            color = Color.White, fontSize = 12.sp, style = MaterialTheme.typography.bodyMedium)
                    }
                    TextButton(
                        onClick = { onBackClick },

                        ){ Text(text = "Edit Profile",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(0xFF1987FB),

                        )

                    }

                }
            }
        }


    }


}


@Composable
fun Listitem(name:String, id:Int){
   Column(
       modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
   ) {
       Row(
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier.padding(8.dp)
       ) {
           Icon(painter = painterResource(id = id), contentDescription = null, tint = Color(0xFF5E5E62))
           Text(text = name, color = Color(0xFF303034), modifier = Modifier
               .weight(1f)
               .padding(start = 8.dp), fontSize = 18.sp)
           Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color(0xFFC7C6CA))
       }
       Spacer(modifier = Modifier.height(8.dp))
       HorizontalDivider(
           color = Color(0xFFEBEBEB),
           thickness = 2.dp,
           modifier = Modifier.padding(start = 8.dp, end = 8.dp)
       )

   }
}

@Composable
fun ListItemsColoumn(){

    val items = mutableListOf(
        "Company Plan" to R.drawable.ic_companyplan,
        "Family Members" to R.drawable.ic_familymembers,
        "Memberships" to R.drawable.ic_memberships,
        "Claim history" to R.drawable.ic_claimhistory,
        "Billing" to R.drawable.ic_billings,
        "Orders" to R.drawable.ic_orders,
        "Autopay" to R.drawable.ic_autopay,
        "Support" to R.drawable.ic_headset
    )

    LazyColumn(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(color = Color.White)
            .padding(top = 32.dp)
    ) {
        items(items) { item ->
            Listitem(name = item.first, id = item.second)
        }
    }

}

