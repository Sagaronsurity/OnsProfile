package com.example.onsprofile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object Profile


@Serializable
object Form

@Serializable
object PlanSelection

@Composable
fun NavController() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Profile) {

        composable<Profile> {
            ProfileScreen(
                { navController.navigate(Form) },
                profiledata("Santhosh Mangaldeep", "Male", "02 Oct 2002", "9876543210", 1.0),
                { name->
                    when(name){
                        "Company Plan" -> navController.navigate(PlanSelection)
                    }
                }
            )
        }
        composable<Form> { Form { navController.navigate(Profile) } }
        composable<PlanSelection> { PlanSelection() }

    }

}