package com.example.registerform

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

data class Feature(val name: String)
data class Item(val title: String, val icon: Int, val description: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDashboard() {
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
    val ls = listOf(
        Item(
            title = "Title 1",
            icon = R.drawable.cat1,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 2",
            icon = R.drawable.cat2,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 3",
            icon = R.drawable.cat3,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 4",
            icon = R.drawable.cat4,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 6",
            icon = R.drawable.cat5,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 7",
            icon = R.drawable.cat6,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 8",
            icon = R.drawable.cat7,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 9",
            icon = R.drawable.cat8,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 10",
            icon = R.drawable.cat9,
            description = "Lorem Ipsum is simply dummy text"
        ),
        Item(
            title = "Title 11",
            icon = R.drawable.cat10,
            description = "Lorem Ipsum is simply dummy text"
        )
    );

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
                modifier = Modifier.height(320.dp).padding(horizontal = 15.dp),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = oneList, key = { it.name }) {
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color.Blue)
                        .padding(10.dp)
                    ){
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
                    items(ls, key = { it.title }) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .background(Color(0xFF7DCEA0), shape = RoundedCornerShape(15.dp)),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(it.icon),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(84.dp)
                                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                            )
                            Column {
                                Text(text = it.title, style = MaterialTheme.typography.titleMedium)
                                Text(text = it.description, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }
        }
    }