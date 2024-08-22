package com.example.onsprofile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModelBottomSheet(border_color : Color, default : String, items : List<String>, placeholder: String){

    var Gender by remember { mutableStateOf(default) }
    val sheetState = rememberModalBottomSheetState()
    var issheetshown by rememberSaveable {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, if (Gender.isNotEmpty()) Color(0xFFC7C6CA) else border_color),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (Gender.isNotEmpty()) Gender else placeholder,
                color = if (Gender.isNotEmpty()) Color(0xFF303034) else Color(0xFFC7C6CA),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 16.dp)
            )
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
                    Spacer(modifier = Modifier.height(12.dp))

                    for(i in items){
                        Spacer(modifier = Modifier.height(12.dp))
                        TextButton(
                            onClick = { Gender = i
                                issheetshown = false }
                        ){
                            Text(text = i, style = MaterialTheme.typography.bodyLarge, color = Color.Gray)
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

}
