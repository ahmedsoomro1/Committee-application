package com.example.commiteeapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.commiteeapp.ui.theme. CommiteeAppTheme

class login_screen : ComponentActivity(){
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RegistrationScreen() {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Committee Dalo", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(60.dp))

            // Email field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Forget Password link/button
            TextButton(
                onClick = { /* Handle forget password logic */ },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Forget Password?")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Login and Signup buttons in the same row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Login button
                Button(onClick = { /* Handle login logic */ }) {
                    Text("Login")
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Signup button
                Button(onClick = { /* Navigate to Signup screen */ }) {
                    Text("Sign up")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun RegistrationScreenPreview() {
        CommiteeAppTheme  {
            RegistrationScreen()
        }
    }

}