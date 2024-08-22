package com.example.onsprofile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWithDialog(modifier: Modifier = Modifier, border_color: Color) {
    var datepickercontroller by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    val dateState = rememberDatePickerState()
    val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")

    val displayText = if (selectedDate != null) {
        val localDate = Instant.ofEpochMilli(selectedDate!!)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
        localDate.format(formatter).toString()
    } else {
        "Select Date"
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, if (selectedDate != null) Color(0xFFC7C6CA) else border_color)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = displayText,
                color = if (selectedDate != null) Color(0xFF303034) else Color.Gray,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontFamily = customFontFamily
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
            IconButton(onClick = { datepickercontroller = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calander),
                    contentDescription = "Dropdown"
                )
            }
        }

        if (datepickercontroller) {
            DatePickerDialog(
                onDismissRequest = { datepickercontroller = false },
                confirmButton = {
                    Button(onClick = {
                        if (dateState.selectedDateMillis != null) {
                            selectedDate = dateState.selectedDateMillis
                            datepickercontroller = false
                        }
                    }) {
                        Text(text = "Ok")
                    }
                },
                dismissButton = {
                    Button(onClick = { datepickercontroller = false }) {
                        Text(text = "Cancel")
                    }
                }
            ) {
                DatePicker(state = dateState)
            }
        }
    }
}
