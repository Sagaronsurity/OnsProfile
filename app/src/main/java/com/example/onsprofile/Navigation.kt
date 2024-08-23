package com.example.onsprofile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object profile


@Serializable
object form


@Composable
fun NavController() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = profile) {

        composable<profile> {

            ProfileScreen(
                { navController.navigate(form) },
                profiledata("Santhosh Mangaldeep", "Male", "02 Oct 2002", "9876543210", .25)
            )
        }
        composable<form> { Form { navController.navigate(profile) } }

    }

}