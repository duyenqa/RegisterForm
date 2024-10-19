package com.example.registerform

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDetail(imageId: Array<Int>, names: Array<String>, description: Array<String>,itemIndex: Int?) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Screen Detail") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = imageId[itemIndex!!]),
                    contentDescription = names[itemIndex],
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                )
            }

            Text(
                text = names[itemIndex!!],
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
            Text(text = "Description")
            Text(
                text = description[itemIndex!!],
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
        }
    }
}