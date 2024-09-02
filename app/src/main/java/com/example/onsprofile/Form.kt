package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun formPreview(){
    Form({})
}



@Composable
fun Form(onClickback: () -> Unit) {

    Scaffold(
        topBar = { Topbar(onClickback) },
        bottomBar = { Buttom() }
    ) {

        Body(Modifier.padding(it))
    }
}


@Composable
fun Topbar(onClickback: () -> Unit) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 16.dp, bottom = 10.dp, end = 16.dp)
                .background(Color.White)

        ) {
            IconButton(onClick = { onClickback() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }

            Column(
                modifier = Modifier.padding(top = 12.dp)
            ) {
                Text(text = "Add/Update Details",
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_semi_bold)),
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    color = Color(0xFF303034))
                Text(
                    text = "Enter the details below to activate your plan",
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    lineHeight = 16.sp,
                    color = Color(0xFF303034))
            }
        }
    }





@Composable
fun Body(modifier: Modifier) {
    val scrollstate = rememberScrollState()
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xFFF2F9FF))
            .verticalScroll(scrollstate)

    ) {

        Surface(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp)),

            ) {

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                OutlinedTextFeild(
                    name = "Susmitha Jami",
                    supportingText = "Name",
                    enabled = true,
                    placeholder = ""
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Gender",
                    color = Color(0xFF5E5E62),
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500)
                )
                Spacer(modifier = Modifier.height(2.dp))
                CustomModelBottomSheet(
                    Color(0xFFC7C6CA),
                    default = "Female",
                    placeholder = "",
                    items = listOf("Male", "Female", "Others")
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Date of Birth",
                    color = Color(0xFF5E5E62),
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500)
                )
                DatePickerWithDialog(border_color = Color(0xFFC7C6CA))
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextFeild(
                    name = "9502438444",
                    supportingText = "Phone Number",
                    enabled = false,
                    placeholder = ""
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextFeild(
                    name = "e.g. abc@gmail.com",
                    supportingText = "Company Email Id",
                    enabled = false,
                    placeholder = ""
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextFeild(
                    name = "e.g. abc@gmail.com",
                    supportingText = "Personal Email ID(optional)",
                    enabled = false,
                    placeholder = ""
                )
            }

        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Nominee Details",
            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.padding(start = 16.dp),
            color = Color(0xFF5E5E62)
        )

        Surface(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp)),
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                OutlinedTextFeild(
                    name = "",
                    supportingText = "Nominee name",
                    enabled = true,
                    placeholder = "Enter Nominee"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "RelationShip",
                    color = Color(0xFF5E5E62),
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500)
                )
                CustomModelBottomSheet(
                    Color(0xFFDE3730),
                    default = "",
                    listOf("Husband", "Father", "Mother", "Brother", "Sister", "Child"),
                    placeholder = "Select Relation"
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Date of Birth",
                    color = Color(0xFF5E5E62),
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500)
                )
                DatePickerWithDialog(border_color = Color(0xFFDE3730))
            }
        }

    }

}




@Composable
fun Buttom() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)

    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFf0188FC),
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.LightGray
            ),
            modifier = Modifier
                .padding(16.dp)
                .height(48.dp),

            ) {
            Text(
                text = "Save & Proceed",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }

}
