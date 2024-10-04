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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onsprofile.ui.theme.OnsProfileTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BenifitsScreen(
   onPayNowClicked : () -> Unit,
   onclaimsClicked : () -> Unit,
   onMemberAdditionClicked : () -> Unit
) {
    val filterSheetState = rememberModalBottomSheetState()
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by remember { mutableStateOf(false) }
    var isFilterOpen by remember { mutableStateOf(false) }
    Scaffold(
        bottomBar = { BottomBar() },
        floatingActionButton = {

        }
    ) { paddingValues ->
        BenifitsBody(
            modifier = Modifier.padding(paddingValues),
            onArrowClicked = {
                isSheetOpen = true
            },
            onFilterClicked = {
                isFilterOpen = true
            },
            onPayNowClicked = onPayNowClicked,
            onClaimsClicked = onclaimsClicked,
            onMemberAdditionClicked = onMemberAdditionClicked

        )
    }
    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {isSheetOpen = false},
            containerColor = Color.White
        ) {
            BenifitsBottomSheet(
                ondismissClicked = {isSheetOpen = false}
            )
        }
    }
    if(isFilterOpen){
        ModalBottomSheet(
            sheetState = filterSheetState,
            onDismissRequest = {isFilterOpen = false},
            containerColor = Color.White
        ) {
            FilterSelectionScreen()
        }
    }
}

@Composable
fun BenifitsBottomSheet(
    ondismissClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "What is Waiting Period?",
            fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(700),
            modifier = Modifier.padding(16.dp),)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = bottomSheetText,
            fontFamily = FontFamily(Font(R.font.hk_grotesk_medium)),
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shadowElevation = 8.dp,
            color = Color.White
        ) {
            Button(modifier = Modifier
                .padding(top = 16.dp, bottom = 18.dp, start = 32.dp, end = 32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0188FC)
                ),
                onClick = {
            ondismissClicked()
            }) {
                Text(text = "Got it !",
                    fontFamily = FontFamily(Font(R.font.hk_grotesk_bold)),
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding(14.dp)
                )
            }
        }
    }
}



@Composable
fun BenifitsBody(
    modifier: Modifier,
    onArrowClicked: () -> Unit,
    onFilterClicked: () -> Unit,
    onPayNowClicked: () -> Unit,
    onClaimsClicked: () -> Unit,
    onMemberAdditionClicked: () -> Unit
) {
    OnsProfileTheme {
        Column(
            modifier = modifier
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

            BenifitsTop()
            BenifitsPlansBody(
                onArrowClicked = onArrowClicked,
                onFiltersClicked = onFilterClicked,
                onPayNowClicked = onPayNowClicked,
                onClaimsClicked = onClaimsClicked,
                onMemberAdditionClicked = onMemberAdditionClicked
            )

        }
    }
}


@Composable
fun BenifitsTop(){
    Row(
        Modifier
            .padding(16.dp)
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
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .clickable { }
                    .padding(start = 24.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_headset),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .clickable { }
                    .padding(start = 24.dp)
            )
        }
    }
}

@Composable
fun BenifitsPlansBody(
    onArrowClicked: () -> Unit,
    onFiltersClicked: () -> Unit,
    onPayNowClicked: () -> Unit,
    onClaimsClicked: () -> Unit,
    onMemberAdditionClicked: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
    ) {
            item { DueRemainder(onPayNowClicked) }
            item { ImageCarouselWithDots() }
            item { OnGoingClaimsRemainder(onClaimsClicked) }
            item { Spacer(modifier = Modifier.height(8.dp)) }
            item {
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
                        modifier = Modifier.weight(1f)
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
                            fontWeight = FontWeight(500)
                        )
                    }
                }
            }
        item { NomineeRemainders(onMemberAdditionClicked) }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { CategoryScreen() }
        item {
                Image(
                    painter = painterResource(R.drawable.banner),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .height(80.dp)
                        .width(328.dp)
                )
        }
        item { BitsRow(onArrowClicked = onArrowClicked) }
    }
}

@Composable
fun CategoryScreen() {
    val categories = listOf("All", "Health", "Accident", "Cyber")
    var selectedCategory by remember { mutableStateOf(categories[0]) }

    // Category selection tabs (LazyRow)
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

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val filteredItems = getItemsForCategory(selectedCategory)
        for(i in 0..filteredItems){
            InsuranceBox()
        }
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
            color = if (isSelected) Color(0xFF0188FC) else Color.Gray,
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




