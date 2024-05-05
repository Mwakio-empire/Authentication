package com.example.Connectify.navigation

import android.window.SplashScreenView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.Connectify.ui.theme.screens.company.AddCompanyScreen
import com.example.Connectify.ui.theme.screens.explore.CategoriesScreen

import com.example.Connectify.ui.theme.screens.home.HomeScreen
import com.example.Connectify.ui.theme.screens.imm.SecondLanding
import com.example.Connectify.ui.theme.screens.immediate.LandingScreen
import com.example.Connectify.ui.theme.screens.login.LoginScreen


import com.example.Connectify.ui.theme.screens.searches.TopSearches

import com.example.Connectify.ui.theme.screens.signup.SignupScreen
import com.example.Connectify.ui.theme.screens.view.ViewScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = LANDING_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }

        composable(LANDING_URL){
            LandingScreen(navController = navController)
        }

        composable(SECOND_LANDING_URL){
            SecondLanding(navController = navController)
        }
        composable(CATEGORIES_URL){
            CategoriesScreen(navController = navController)
        }
        composable(SEARCH_URL){
            TopSearches(navController = navController)
        }
        composable(VIEW_URL){
            ViewScreen(navController = navController)
        }
        composable(ADD_COMPANY_URL){
            AddCompanyScreen(navController = navController)
        }

    }
}