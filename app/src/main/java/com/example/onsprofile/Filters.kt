package com.example.onsprofile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun FilterSelectionScreen(  ) {
    val filters = listOf("Members", "Insurance Type", "Paid By", "Provider")
    val selectedFilter = remember { mutableStateOf(filters[0]) }

    val filterOptions = mapOf(
        "Members" to listOf("Sagar", "Susmitha", "Munny", "Cherry"),
        "Insurance Type" to listOf("Health", "Life", "Vehicle"),
        "Paid By" to listOf("Company", "Self", "Third-Party"),
        "Provider" to listOf("Provider A", "Provider B", "Provider C")
    )


    val selectedOptions = remember {
        mutableStateMapOf<String, MutableList<String>>()
    }

    Column {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Filters",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                lineHeight = 20.sp,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Clear All",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 12.sp,
                fontWeight = FontWeight(700),
                lineHeight = 16.sp,
                color = Color(0xFF0188FC),
                modifier = Modifier.clickable {
                    filters.forEach { selectedOptions[it]?.clear() }
                }
            )
        }

        HorizontalDivider()

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                filters.forEach { filter ->
                    Text(
                        text = filter,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedFilter.value = filter }
                            .padding(vertical = 8.dp),
                        fontFamily = if (selectedFilter.value == filter) FontFamily(Font(R.font.hk_grotesk_bold)) else FontFamily(
                            Font(R.font.hk_grotesk_medium)
                        ),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 20.sp,
                    )
                }
            }

            VerticalDivider(
                thickness = 1.dp,
                modifier = Modifier
                    .width(1.dp)
                    .height(258.dp)
            )

            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(16.dp)
            ) {
                LazyColumn {
                    filterOptions[selectedFilter.value]?.forEach { option ->
                        item {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                val isSelected =
                                    selectedOptions[selectedFilter.value]?.contains(option) == true

                                Checkbox(
                                    checked = isSelected,
                                    onCheckedChange = { isChecked ->
                                        selectedOptions[selectedFilter.value] = if (isChecked) {
                                            selectedOptions[selectedFilter.value]?.apply {
                                                add(option)
                                            } ?: mutableListOf()
                                        } else {
                                            selectedOptions[selectedFilter.value]?.apply {
                                                remove(option)
                                            } ?: mutableListOf()
                                        }
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFF0188FC),
                                        uncheckedColor = Color(0xFFC7C6CA)
                                    )
                                )

                                Text(
                                    text = option,
                                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight(500),
                                    lineHeight = 20.sp,
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        HorizontalDivider()

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "3 Plans",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                lineHeight = 28.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            )
            Button(
                onClick = {  },
                modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0188FC),
                    contentColor = Color.White
                )
            ) {
                Text(
                    "Apply Filters",
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}
