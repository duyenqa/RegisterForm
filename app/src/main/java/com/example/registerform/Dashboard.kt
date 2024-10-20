package com.example.registerform

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Feature(val name: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDashboard(
    imageId: Array<Int>,
    names: Array<String>,
    navController: NavController
) {
    val oneList = listOf(
        Feature(
            name = "Item 1"
        ),
        Feature(
            name = "Item 2"
        ),
        Feature(
            name = "Item 3"
        ),
        Feature(
            name = "Item 4"
        ),
        Feature(
            name = "Item 5"
        ),
        Feature(
            name = "Item 6"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Screen Dashboard") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            //Content 1
            Text(
                text = "List 1",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .height(320.dp)
                    .padding(horizontal = 15.dp),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = oneList, key = { it.name }) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Blue)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = it.name,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(20.dp),
                            color = Color.White
                        )
                    }
                }
            }

            //Content 2
            Text(
                text = "List 2",
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            LazyRow(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(items = oneList, key = { it.name }) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Green)
                    ) {
                        Text(
                            text = it.name,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(20.dp),
                            color = Color.White
                        )
                    }
                }
            }

            //Content 3
            Text("List 3", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 15.dp))
            LazyColumn(
                modifier = Modifier.height(800.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                val itemCount = imageId.size
                items(itemCount, key = { it }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .background(Color(0xFF7DCEA0), shape = RoundedCornerShape(15.dp)),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(imageId[it]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(8.dp)
                                .size(84.dp)
                                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                        )
                        Column {
                            Text(text = names[it], style = MaterialTheme.typography.titleMedium)

                            SuggestionChip(
                                onClick = { navController.navigate(route = "screen_detail/$it") },
                                label = { Text(text = "View Detail", color = Color.DarkGray, style = MaterialTheme.typography.bodyMedium) },
                                border = BorderStroke(
                                    width = 1.dp,
                                    color = Color.DarkGray
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
