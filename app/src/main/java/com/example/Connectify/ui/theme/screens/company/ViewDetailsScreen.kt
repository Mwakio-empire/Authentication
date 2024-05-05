package com.example.Connectify.ui.theme.screens.company

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.Connectify.data.CompanyViewModel
import com.example.Connectify.models.Company
import com.example.Connectify.ui.theme.AuthenticationTheme


fun ProductItem(JobTitle: String, companydescription: String, Jobsummary: String, qualification: String, id: String, navController: NavHostController, productRepository: CompanyViewModel, productImage: String) {

}

@Composable
fun ViewDetailsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = CompanyViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Company("","","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Company>() }

        var products = productRepository.allProducts(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(products){
                    ProductItem(
                        JobTitle = it.JobTitle,
                        companydescription = it.companydescription,
                        Jobsummary = it.Jobsummary,
                        qualification = it.qualification,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository,
                        productImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(JobTitle:String,companydescription:String ,Jobsummary:String,qualification:String , imageUrl: String, id: String,
                navController:NavHostController,
                productRepository:CompanyViewModel, productImage:String ) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(text = JobTitle)
        Text(text = companydescription)
        Text(text = Jobsummary)
        Text(text = qualification)
        Image(
            painter = rememberAsyncImagePainter(productImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}



@Composable
@Preview(showBackground = true)
fun ViewDetailsScreenPreview() {
    AuthenticationTheme {
        ViewDetailsScreen(navController = rememberNavController())
    }
}