package com.example.onsprofile

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun FloatingActionButton(){
    Icon(
        painter = painterResource(id = R.drawable.ic_floatingicon),
        contentDescription = null,
        tint = Color.Unspecified,
        modifier = Modifier
    )
// fees , teaching non teaching  salary , Finance , donations , scolarships , expenses like pekinic
}