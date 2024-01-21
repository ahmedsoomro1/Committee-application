package com.example.commiteeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import com.example.commiteeapp.ui.theme.CommiteeAppTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.commiteeapp.ui.theme.MyApplicationKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationKotlinTheme {
                val navController: NavHostController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "onboardingScreen2"
                ) {
                    composable("onboardingScreen2") { instruction_screen.OnboardingScreen2(navController) }
                    composable("policiesScreen") { policies_screen.OnboardingScreen() }
                }
            }
        }
    }
}


