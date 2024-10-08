package com.example.onsprofile


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFeild(name : String,supportingText : String,enabled : Boolean,placeholder  : String){
    var text by remember { mutableStateOf(name) }
    Text(text = supportingText,
        color = if(!enabled) Color(0xFFC7C6CA) else Color(0xFF5E5E62),
        fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
        fontWeight = FontWeight(500),
        fontSize = 12.sp,
        lineHeight = 16.sp
        )
    Spacer(modifier = Modifier.height(2.dp))
    OutlinedTextField(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        value = text,
        enabled = enabled,
        placeholder = {
            Text(text = placeholder, color = Color(0xFFC7C6CA),
            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                lineHeight = 20.sp
            )
                      },
        onValueChange = { newText -> text = newText },
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            lineHeight = 20.sp,
            color = if (!enabled) Color(0xFFC7C6CA) else Color(0xFF303034)
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = if (text.isEmpty()) Color(0xFFDE3730) else Color(0xFFC7C6CA),
            unfocusedBorderColor = if (text.isEmpty()) Color(0xFFDE3730) else Color(0xFFC7C6CA)
        )
    )
}