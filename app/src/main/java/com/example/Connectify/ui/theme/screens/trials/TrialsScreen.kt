package com.example.Connectify.ui.theme.screens.trials

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.Connectify.navigation.ADD_PRODUCTS_URL
import com.example.Connectify.navigation.VIEW_PRODUCTS_URL
import com.example.Connectify.ui.theme.AuthenticationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrialsScreen(navController: NavHostController){


    Button(onClick = {
        navController.navigate(ADD_PRODUCTS_URL)
    }) {
        Text(text = "Add Products")
    }
    Spacer(modifier = Modifier.height(30.dp))
    Button(onClick = {
        navController.navigate(VIEW_PRODUCTS_URL)
    }) {
        Text(text = "View Products")
    }
}
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TrialsScreenPreview(){
    AuthenticationTheme {
        TrialsScreen(navController = rememberNavController())
    }
}