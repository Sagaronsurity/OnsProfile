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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Preview(){
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
    Box(
        modifier = Modifier.background(Color.White)
    ) {
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
                Text(text = "Add/Update Details", style = MaterialTheme.typography.bodyLarge.copy(
                    fontFamily = customFontFamily,
                    fontSize = 16.sp
                ))
                Text(
                    text = "Enter the details below to activate your plan",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontFamily = customFontFamily,
                        fontSize = 12.sp
                    )
                )
            }
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
                    name = "Shreya Murali",
                    supportingText = "Name",
                    enabled = true,
                    placeholder = ""
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Gender",
                    modifier = Modifier.padding(start = 10.dp),
                    color = Color.Gray
                )
                CustomModelBottomSheet(
                    Color.Gray,
                    default = "Female",
                    placeholder = "",
                    items = listOf("Male", "Female", "Others")
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Date of Birth",
                    modifier = Modifier.padding(start = 10.dp),
                    color = Color.Gray
                )
                DatePickerWithDialog(border_color = Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextFeild(
                    name = "9502438444",
                    supportingText = "Phone Number",
                    enabled = false,
                    placeholder = ""
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextFeild(
                    name = "e.g. abc@gmail.com",
                    supportingText = "Company Email Id",
                    enabled = false,
                    placeholder = ""
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextFeild(
                    name = "e.g. abc@gmail.com",
                    supportingText = "Personal Email ID(optional)",
                    enabled = true,
                    placeholder = ""
                )
            }

        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Nominee Details",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 16.dp),
            color = Color(0xFF5E5E62)
        )
        Spacer(modifier = Modifier.height(8.dp))
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
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Relationship",
                    modifier = Modifier.padding(start = 10.dp),
                    color = Color.Gray
                )
                CustomModelBottomSheet(
                    Color(0xFFDE3730),
                    default = "",
                    listOf("Husband", "Father", "Mother", "Brother", "Sister", "Child"),
                    placeholder = "Select Relation"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Date of Birth",
                    modifier = Modifier.padding(start = 10.dp),
                    color = Color.Gray
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
            Text(text = "Save & Proceed", style = MaterialTheme.typography.bodyLarge)

        }
    }

}
