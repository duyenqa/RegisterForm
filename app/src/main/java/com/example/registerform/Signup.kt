package com.example.registerform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLogin(navigateToB: () -> Unit){
    var firstName by remember  { mutableStateOf("") }
    var lastName by remember  { mutableStateOf("") }
    var age by remember  { mutableStateOf("") }
    var userName by remember  { mutableStateOf("") }
    var password by remember  { mutableStateOf("") }
    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            title = { Text(text = "Registration Success") },
            text = {
                Text(text = "Welcome" + " $lastName" + " $firstName")
            },
            confirmButton = {
                TextButton(onClick = { showDialog.value = false }) { Text("Register") }
            },
            dismissButton = {
                TextButton(onClick = { showDialog.value = false }) { Text("Cancel") }
            }
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Register Form") })
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = firstName,
                onValueChange = {newText -> firstName = newText},
                label = { Text(text = "First Name") },
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = lastName,
                onValueChange = {newText -> lastName = newText},
                label = { Text(text = "Last Name") },
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = age,
                onValueChange = {newText -> age = newText},
                label = { Text(text = "Age") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = userName,
                onValueChange = {newText -> userName = newText},
                label = { Text(text = "Username") },
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                value = password,
                onValueChange = {newText -> password = newText},
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier.height(50.dp).fillMaxWidth().padding(horizontal = 15.dp),
                onClick = { showDialog.value = true }
            ) {
                Text(text = "Register", fontSize = 20.sp,fontWeight = FontWeight.Bold)
            }
        }
    }
}