package com.dsm.firebaseauth2

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dsm.firebaseauth2.presentation.home.HomeScreen
import com.dsm.firebaseauth2.presentation.initial.InitialScreen
import com.dsm.firebaseauth2.presentation.login.LoginScreen
import com.dsm.firebaseauth2.presentation.signup.SignUpScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavigationWrapper(
    navHostController: NavHostController,
    auth: FirebaseAuth
){
    NavHost(navController=navHostController, startDestination ="home" ) {//initial
        composable("initial"){
            InitialScreen(
                navigateToLogin={navHostController.navigate("logIn")},
                navigateToSignUp={navHostController.navigate("signUp")}
            )
        }
        composable("logIn"){
            LoginScreen(
                auth,
                navigateToSignUp={navHostController.navigate("signUp")}
            )

        }
        composable("signUp"){
            SignUpScreen(auth)
        }
        composable("home"){
            HomeScreen()
        }
    }

}