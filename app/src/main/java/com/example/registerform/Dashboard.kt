package com.example.registerform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

data class Item(val title: String, val icon: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDashboard() {
    val ls = listOf(
        Item(
            title = "Text 1",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 2",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 3",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 4",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 6",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 7",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 8",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 9",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 10",
            icon = R.drawable.baseline_arrow_forward_ios_24
        ),
        Item(
            title = "Text 11",
            icon = R.drawable.baseline_arrow_forward_ios_24
        )
    );

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Screen Dashboard") })
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            LazyColumn(
                modifier = Modifier.height(800.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(ls, key = { it.title }) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color.LightGray)
                        .padding(20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = it.title,fontSize = 18.sp)
                        Icon(
                            painter = rememberAsyncImagePainter
                                (model = R.drawable.baseline_arrow_forward_ios_24),
                            "icon",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}