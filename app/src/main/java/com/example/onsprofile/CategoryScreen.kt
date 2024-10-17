package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryScreen(
    onFiltersClicked : () -> Unit
) {
    val categories = listOf("All", "Health", "Accident", "Cyber")
    var selectedCategory by remember { mutableStateOf(categories[0]) }

    Column {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Active Plans",
                fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.weight(1f),
                color = Color(0xFF303034)
            )
            Row(
                modifier = Modifier.clickable { onFiltersClicked() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_filters),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Filters",
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF303034)
                )
            }
        }


        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(categories) { category ->
                CategoryTab(
                    category = category,
                    isSelected = category == selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        val filteredItems = getItemsForCategory(selectedCategory)
        for (i in 0..filteredItems) {
            InsuranceBox()
        }
//        ListApiFailuer()
    }
}

fun getItemsForCategory(category: String): Int {
    val allItems = 6
    return when (category) {
        "All" -> allItems
        "Health" -> 2
        "Cyber" -> 3
        "Accident" -> 1
        else -> 0
    }
}

@Composable
fun CategoryTab(category: String, isSelected: Boolean, onCategorySelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 28.dp)
            .clickable { onCategorySelected(category) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = category,
            color = if (isSelected) Color(0xFF0188FC) else Color(0xFF5E5E62),
            fontFamily = FontFamily(Font(R.font.hk_grotesk_regular)),
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .width((category.length * 9).dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(48.dp))
                    .background(Color(0xFF0188FC))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    CategoryScreen(onFiltersClicked = {})
}




