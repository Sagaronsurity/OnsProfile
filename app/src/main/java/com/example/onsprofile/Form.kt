package com.example.onsprofile

import android.app.DatePickerDialog
import android.widget.Button
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date


@Composable
fun Form(onClickback: () -> Unit){

    Scaffold(
        topBar = { },
        bottomBar = { onClickback }
    ) {

        Body(Modifier.padding(it))

    }


}


@Composable
fun Topbar(onClickback : ()->Unit){
   Box(
       modifier = Modifier.background(Color.White)
   ) {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(16.dp)
               .background(Color.White)

       ) {
           IconButton(onClick = { onClickback }) {
               Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
           }

           Column(
               modifier = Modifier.padding(top=12.dp)
           ) {
               Text(text = "Add/Update Details", style = MaterialTheme.typography.bodyLarge)
               Text(text = "Enter the details below to activate your plan", style = MaterialTheme.typography.bodySmall)
           }
       }
   }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(modifier: Modifier){
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
                var text by remember { mutableStateOf("Shreya Murali") }
                Text(text = "Name", modifier = Modifier.padding(start = 10.dp), color = Color.Gray)
                OutlinedTextField(
                        value = text,
                        onValueChange = { newText -> text = newText },
                        shape = RoundedCornerShape(12.dp),
                        textStyle = TextStyle(Color(0xFF303034)),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.Gray

                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .height(48.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Gender", modifier = Modifier.padding(start = 10.dp), color = Color.Gray)
                GenderDetails(Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Date of Birth", modifier = Modifier.padding(start = 10.dp), color = Color.Gray)
                DatePickerWithDialog(border_color = Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Phone Number", modifier = Modifier.padding(start = 10.dp), color = Color(0xFFE2E3E6))
                OutlinedTextField(
                    value = "9502438444",
                    enabled = false,
                    onValueChange = {},
                    shape = RoundedCornerShape(12.dp),
                    textStyle = TextStyle(Color(0xFFE2E3E6)),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFE2E3E6),
                        unfocusedBorderColor = Color(0xFFE2E3E6)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(48.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Company Email ID", modifier = Modifier.padding(start = 10.dp), color = Color(0xFFE2E3E6))
                OutlinedTextField(
                    value = "e.g. abc@gmail.com",
                    onValueChange = {},
                    enabled = false,
                    shape = RoundedCornerShape(12.dp),
                    textStyle = TextStyle(Color(0xFFE2E3E6)),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFE2E3E6),
                        unfocusedBorderColor = Color(0xFFE2E3E6)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(48.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                var pemail by remember { mutableStateOf("e.g. abc@gmail.com") }
                Text(text = "Personal Email ID(optional)", modifier = Modifier.padding(start = 10.dp), color = Color.Gray)
                OutlinedTextField(
                    value = pemail,
                    onValueChange = { newText -> pemail = newText },
                    shape = RoundedCornerShape(12.dp),
                    textStyle = TextStyle(Color(0xFFE2E3E6)),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFE2E3E6),
                        unfocusedBorderColor = Color(0xFFE2E3E6)

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(48.dp)
                )




            }

        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Nominee Details",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp)),

            ){

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                var nominneNmae by remember { mutableStateOf("") }
                Text(text = "Nominne Name", modifier = Modifier.padding(start = 10.dp), color = Color.Gray)
                OutlinedTextField(
                    value = nominneNmae,
                    onValueChange = { newText -> nominneNmae = newText },
                    placeholder = { Text(text = "Enter Nominee Name", style = MaterialTheme.typography.bodyMedium, color = Color.Gray) },
                    shape = RoundedCornerShape(12.dp),
                    textStyle = TextStyle(Color(0xFF303034)),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFFDE3730),
                        unfocusedBorderColor = Color(0xFFDE3730)

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(48.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
//                var relationship by remember { mutableStateOf("") }
                Text(text = "Relationship", modifier = Modifier.padding(start = 10.dp), color = Color.Gray)
//                OutlinedTextField(
//                    value = relationship,
//                    onValueChange = { newText -> relationship = newText },
//                    placeholder = { Text(text = "Enter Nominee Name", style = MaterialTheme.typography.bodyMedium, color = Color.Gray)},
//                    shape = RoundedCornerShape(12.dp),
//                    textStyle = TextStyle(Color(0xFF303034)),
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedBorderColor = Color(0xFFDE3730),
//                        unfocusedBorderColor = Color(0xFFDE3730)
//
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp)
//                        .height(48.dp)
//                )
                GenderDetails(Color(0xFFDE3730))
                Spacer(modifier = Modifier.height(8.dp))
                DatePickerWithDialog(border_color = Color(0xFFDE3730))
            }
        }






    }

}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField() {
    var text by remember { mutableStateOf("Shreya Murali") }

    Column {
        Text(text = "Name", modifier = Modifier.padding(start = 10.dp))
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            shape = RoundedCornerShape(12.dp),
            textStyle = TextStyle(Color.Gray),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray, // Border color when focused
                unfocusedBorderColor = Color.Gray // Border color when not focused

            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderDetails(border_color : Color){

    var Gender by remember { mutableStateOf("Female") }
    var sheetState = rememberModalBottomSheetState()
    var issheetshown by rememberSaveable {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(48.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, border_color),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = Gender, color = Color(0xFF303034),
                style = MaterialTheme.typography.bodyMedium,
                modifier =Modifier.padding(start = 8.dp))
            IconButton(onClick = {
                issheetshown = true
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_downarrow), contentDescription = "Dropdown")
            }
        }

        if(issheetshown){
            ModalBottomSheet(
                onDismissRequest = { issheetshown = false },
                sheetState = sheetState
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Select Relation", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(24.dp))

                    TextButton(
                        onClick = { Gender = "Husband"
                            issheetshown = false }
                    ){
                        Text(text = "Husband", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(
                        color = Color(0xFFEBEBEB),
                        thickness = 2.dp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    TextButton(
                        onClick = { Gender = "Father"
                            issheetshown = false}
                    ){
                        Text(text = "Father", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(
                        color = Color(0xFFEBEBEB),
                        thickness = 2.dp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    TextButton(
                        onClick = { Gender = "Mother"
                            issheetshown = false}
                    ){
                        Text(text = "Mother", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(
                        color = Color(0xFFEBEBEB),
                        thickness = 2.dp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    TextButton(
                        onClick = { Gender = "Brother"
                            issheetshown = false}
                    ){
                        Text(text = "Brother", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(
                        color = Color(0xFFEBEBEB),
                        thickness = 2.dp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    TextButton(
                        onClick = { Gender = "Sister"
                            issheetshown = false}
                    ){
                        Text(text = "Sister", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(
                        color = Color(0xFFEBEBEB),
                        thickness = 2.dp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    TextButton(
                        onClick = { Gender = "Child"
                            issheetshown = false}
                    ){
                        Text(text = "Child", style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(
                        color = Color(0xFFEBEBEB),
                        thickness = 2.dp
                    )

                }

            }
        }
    }

}


@Composable
fun Buttom(){

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)

    ) {
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFf0188FC),      // Background color
            contentColor = Color.White,       // Text color
            disabledContainerColor = Color.Gray,  // Background color when disabled
            disabledContentColor = Color.LightGray // Text color when disabled
        ),
            modifier = Modifier
                .padding(16.dp)
                .height(48.dp),

        ) {
            Text(text = "Save & Proceed", style = MaterialTheme.typography.bodyLarge)
            
        }
    }

}


@Preview(showBackground = true)
@Composable
fun FormPreview(){
    Body(Modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWithDialog(modifier: Modifier = Modifier,border_color : Color) {

    var datepickercontroller by remember {
        mutableStateOf(false)
    }

    var Date by remember {
        mutableLongStateOf(Date().time)
    }
    val DateState = rememberDatePickerState()

    var mills =  Date
    val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")
    val local_date = Instant.ofEpochMilli(mills)
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
    var Local_date = local_date.format(formatter).toString()





    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(48.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, border_color),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = Local_date, color = Color(0xFF303034),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 8.dp)
            )
            IconButton(onClick = {
                datepickercontroller = true
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_calander), contentDescription = "Dropdown")
            }
        }

        if(datepickercontroller){
            DatePickerDialog(onDismissRequest = { datepickercontroller = false },
                confirmButton = { Button(onClick = {
                    if(DateState.selectedDateMillis != null){
                        Date = DateState.selectedDateMillis!!
                        datepickercontroller = false

                    }
                }) {
                    Text(text = "Ok")
                } },
                dismissButton = {
                    Button(onClick = { datepickercontroller = false }) {
                        Text(text = "Cancel")
                        
                    }
                }
            ) {

                DatePicker(state = DateState)
                
            }
        }
    }

}

