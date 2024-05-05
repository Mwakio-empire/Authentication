package com.example.Connectify.ui.theme.screens.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.Connectify.R
import com.example.Connectify.navigation.ADD_COMPANY_URL
import com.example.Connectify.navigation.ADD_PRODUCTS_URL
import com.example.Connectify.navigation.CATEGORIES_URL
import com.example.Connectify.navigation.LANDING_URL
import com.example.Connectify.navigation.VIEW_PRODUCTS_URL
import com.example.Connectify.ui.theme.AuthenticationTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            floatingActionButton = {
                FloatingActionButton(onClick = {
                    navController.navigate(ADD_COMPANY_URL)

                }) {
                    IconButton(onClick = { navController.navigate(ADD_COMPANY_URL) }) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
                val mContext = LocalContext.current
                Column(

                    modifier = Modifier
                        .fillMaxSize()
                        .paint(
                            painterResource(id = R.drawable.bcg2),
                            contentScale = ContentScale.FillBounds
                        )

                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {




                    //topApp bar
                    TopAppBar(title = { Text(text = "Home" , color = Color.Black, modifier = Modifier.padding(start = 15.dp )) },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(Color.White),
                        actions = {
                            IconButton(onClick = { val shareIntent= Intent(Intent.ACTION_SEND)
                                shareIntent.type="text/plain"
                                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))}) {
                                Icon(imageVector = Icons.Default.Share, contentDescription = "share",
                                    tint = Color.Black)

                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Settings, contentDescription = "settings",
                                    tint = Color.Black)

                            }
                        }
                    )



                    //end of top app bar
                    Column (modifier = Modifier
                        .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){


                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            modifier = Modifier.padding(start = 20.dp),
                            text = "Find your dream job",
                            fontSize = 40.sp,


                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black
                        )



                        Spacer(modifier = Modifier.height(10.dp))
                        //searchbar

                        Row {
                            TextField(value = "", onValueChange = {},
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                },
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                                    focusedContainerColor = MaterialTheme.colorScheme.surface
                                ), placeholder = { Text(text = "Search")},
                                modifier = Modifier.fillMaxWidth().heightIn(min = 50.dp))
                        }


                        Row {


                            Text(
                                modifier = Modifier,
                                text = "Explore Categories:",
                                fontSize = 30.sp,
                                textAlign = TextAlign.Left,

                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Cursive,
                                color = Color.Black,
                                textDecoration = TextDecoration.Underline
                            )

                            IconButton(onClick = { navController.navigate(CATEGORIES_URL) }, modifier = Modifier.padding(top = 1.dp)) {
                                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "settings",
                                    tint = Color.Red)

                            }

                        }

                        // Row1
                        Row (modifier = Modifier.horizontalScroll(rememberScrollState())){
                            // row1 part1
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp),
                                    RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp)

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Row {


                                            Spacer(modifier = Modifier.height(5.dp))
                                            Image(
                                                painter = painterResource(id = R.drawable.health),
                                                contentDescription = "footy",
                                                modifier = Modifier
                                                    .clip(shape = CircleShape),
                                                contentScale = ContentScale.Crop

                                            )
                                        }

                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Row {


                                        androidx.compose.material3.Text(
                                            text = "Health",
                                            fontSize = 18.sp,
                                            fontFamily = FontFamily.Serif,
                                            fontWeight = FontWeight.ExtraBold,
                                            textAlign = TextAlign.Center
                                        )


                                    }



                                }


                                Spacer(modifier = Modifier.height(5.dp))


                            }
                            Spacer(modifier = Modifier.width(15.dp))


// End of row1 part1

                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp),
                                    RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp)

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.it),
                                            contentDescription = "footy",
                                            modifier = Modifier
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop

                                        )


                                    }
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Row {


                                        androidx.compose.material3.Text(
                                            text = "Computer",
                                            fontSize = 13.sp,
                                            fontFamily = FontFamily.Serif,
                                            fontWeight = FontWeight.ExtraBold,
                                            textAlign = TextAlign.Center
                                        )


                                    }



                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(15.dp))
//end of column 2



                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp),
                                    RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp)

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.sscience),
                                            contentDescription = "footy",
                                            modifier = Modifier
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop

                                        )


                                    }
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Row {


                                        androidx.compose.material3.Text(
                                            text = "Science",
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily.Serif,
                                            fontWeight = FontWeight.ExtraBold,
                                            textAlign = TextAlign.Center
                                        )


                                    }



                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(15.dp))
//end of column 3

                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(80.dp)
                                        .padding(start = 10.dp),
                                    RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp)

                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center,

                                        ) {
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.health1),
                                            contentDescription = "footy",
                                            modifier = Modifier
                                                .clip(shape = CircleShape),
                                            contentScale = ContentScale.Crop

                                        )


                                    }



                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(35.dp))







                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        // End of Row1

                        Row {


                            Text(
                                modifier = Modifier.padding(start = 0.2.dp),
                                text = "Top Searches:",
                                fontSize = 30.sp,

                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily.Cursive,
                                color = Color.Black,
                                textDecoration = TextDecoration.Underline

                                )


                            IconButton(
                                onClick = { navController.navigate(CATEGORIES_URL) },
                                modifier = Modifier.padding(top = 1.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = "settings",
                                    tint = Color.Red
                                )

                            }
                        }


                        Spacer(modifier = Modifier.height(10.dp))

                        // Row1
                        Row (modifier = Modifier.horizontalScroll(rememberScrollState())){
                            // row1 part1
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(110.dp)
                                        .padding(start = 10.dp)
                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {


                                    }


                                    Spacer(modifier = Modifier.height(5.dp))

                                    androidx.compose.material3.Text(
                                        text = "Software Engineer",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Spacer(modifier = Modifier.height(15.dp))

                                    androidx.compose.material3.Text(
                                        text = "7 jobs are available",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        textAlign = TextAlign.Center
                                    )
                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(15.dp))


// End of row1 part1

                            // row1 part2
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(110.dp)
                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {


                                    }


                                    Spacer(modifier = Modifier.height(5.dp))

                                    androidx.compose.material3.Text(
                                        text = "Software Engineer",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Spacer(modifier = Modifier.height(15.dp))

                                    androidx.compose.material3.Text(
                                        text = "7 jobs are available",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        textAlign = TextAlign.Center
                                    )
                                }


                                Spacer(modifier = Modifier.height(5.dp))

                            }
                            Spacer(modifier = Modifier.width(15.dp))


// End of row1 part2

                            // row1 part3
                            Column {

                                Card(
                                    modifier = Modifier
                                        .height(150.dp)
                                        .width(110.dp)
                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {

                                    }


                                    Spacer(modifier = Modifier.height(5.dp))

                                    androidx.compose.material3.Text(
                                        text = "Software Engineer",
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily.Serif,
                                        fontWeight = FontWeight.ExtraBold,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))

                                    Spacer(modifier = Modifier.height(15.dp))

                                    androidx.compose.material3.Text(
                                        text = "7 jobs are available",
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily.Serif,
                                        textAlign = TextAlign.Center
                                    )
                                }


                                Spacer(modifier = Modifier.height(5.dp))
                            }

                        }


// End of row1 part3

                        // End of Row1

                    }
                }


            }

        )

    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Login",
        route="login",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Profile",
        route="signup",
        selectedIcon=Icons.Filled.Face,
        unselectedIcon=Icons.Outlined.Face,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    AuthenticationTheme {
        HomeScreen(navController = rememberNavController())



    }
}
