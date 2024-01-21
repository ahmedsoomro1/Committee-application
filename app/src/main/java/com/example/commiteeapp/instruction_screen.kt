package com.example.commiteeapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.commiteeapp.ui.theme.CommiteeAppTheme


class instruction_screen : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OnboardingScreen2(navController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Text(
                "Committee Dalo",
                style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.height(60.dp))

            // Line "Instructions"
            Text(text = "Instructions", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(40.dp))

            // List of Instructions (Replace with your actual list)
            LazyColumn {
                items(5) { index ->
                    Text(text = "Instruction $index", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Skip and Next Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Skip Button
                Button(
                    onClick = { /* Handle skip logic */ },
                    colors = ButtonDefaults.buttonColors(
                        //backgroundColor = Color.Blue
                    ),
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Icon(imageVector = Icons.Default.SkipPrevious, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Skip", style = MaterialTheme.typography.bodyMedium)
                    }
                }

                // Next Button
                Button(
                    onClick = {
                        navController.navigate("policiesScreen")
                              /* Handle next logic */ },
                    colors = ButtonDefaults.buttonColors(
                        //  backgroundColor = Color.Blue
                    ),
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Next", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                    }
                }
            }
        }
    }
    @Composable
    @Preview(showBackground = true)
    fun OnboardingScreen2Preview() {
        CommiteeAppTheme  {
            val navController = rememberNavController()
            OnboardingScreen2(navController)
        }
    }
}