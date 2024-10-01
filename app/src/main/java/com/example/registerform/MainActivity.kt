package com.example.registerform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.AlertDialog
import androidx.compose.ui.text.style.TextAlign
import com.example.registerform.ui.theme.RegisterFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterFormTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
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
                TextButton(onClick = { showDialog.value = false }) { Text("Confirm") }
            },
            dismissButton = {
                TextButton(onClick = { showDialog.value = false }) { Text("Dismiss") }
            }
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Text(
                text = "Register Form",
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp, bottom = 15.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
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
                modifier = Modifier.height(50.dp).fillMaxWidth(),
                onClick = { showDialog.value = true }
            ) {
                Text(text = "Register", fontSize = 20.sp,fontWeight = FontWeight.Bold)
            }
        }
    }

}

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String
) {
    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Cancel")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RegisterFormTheme {
        Greeting()
    }
}