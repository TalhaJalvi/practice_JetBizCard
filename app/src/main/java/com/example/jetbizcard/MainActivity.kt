package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
                {
                    CreateBizCard()
                }
            }
        }
    }
}


@Composable
fun CreateBizCard(){
    val buttonClickedState = remember{
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            backgroundColor =  Color.White,
            shape = RoundedCornerShape(size = 15.dp),
            elevation = 4.dp,) {

            //For arrangement using colum
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                //Creating canvas for our profile picture
                CreateImageProfile()
                Divider(modifier = Modifier.height(2.dp))
                InfoSection()
                //Creating portfolio button
                Button(onClick =
                {
                    buttonClickedState.value=!buttonClickedState.value
                }
                )
                {
                    Text(text = "Portfolio",
                        style = MaterialTheme.typography.button)
                }

                if (buttonClickedState.value ){
                    Content()
                }
                else{ Box {}
                }
            }

        }
    }
}


@Preview
@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)) {

        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(3.dp),
            border = BorderStroke(2.dp, color = Color.Gray),
            shape = RoundedCornerShape(4.dp) ) {
            Portfolio(data = listOf("Project1","Project2","Project3"))

        }

    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        //Passing parameter as function Lambda
        items(data){ item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                elevation = 4.dp,
                shape = RectangleShape) {
                Row (modifier = Modifier
                    .padding(2.dp)
                    .background(MaterialTheme.colors.surface)
                ){
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    //Column for arranging our text in center vertically
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Good Project", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

@Composable
private fun InfoSection() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Talha Abbas Jalvi",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Compose Prorammer",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@talhajalvi",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(3.dp)
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = modifier
            .size(size = 150.dp)
            .padding(5.dp),
        border = BorderStroke(0.5.dp, Color.LightGray),
        shape = CircleShape,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
        elevation = 4.dp,
    ) {
        //To get imae inside surface
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}