package com.example.commiteeapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.commiteeapp.ui.theme.MyApplicationKotlinTheme


class policies_screen : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OnboardingScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Text(text = "Committee Dalo", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            // Line "Policies"
            Text(text = "Policies", style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(20.dp))

            // List of Policies (Replace with your actual list)
            LazyColumn {
                items(5) { index ->
                    Text(text = "Policy $index", style = MaterialTheme.typography.headlineMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Continue Button
            Button(
                onClick = { /* Handle continue logic */ },
                colors = ButtonDefaults.buttonColors(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Continue", style = MaterialTheme.typography.bodyMedium)
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun OnboardingScreenPreview() {
        MyApplicationKotlinTheme {
            OnboardingScreen()
        }
    }
}