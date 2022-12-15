package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

           //For arrangment using colum
           Column(modifier = Modifier.height(300.dp),
                  verticalArrangement = Arrangement.Top,
                  horizontalAlignment = Alignment.CenterHorizontally) {
               //Creating canvas for our profile picture
               CreateImageProfile()
               Divider(modifier = Modifier.height(2.dp),)
               Text(text = "Talha Abbas Jalvi +",
                   color = Color.Blue,
                   fontSize = 35.sp,
                   fontWeight = FontWeight.Bold,
                   textAlign = TextAlign.Center
                   )
               Text(text = "Android Compose Programmer @themilescompose",
                   fontSize = 23.sp,
                   textAlign = TextAlign.Center)
               Button(onClick = { /*TODO*/ },
                   modifier = Modifier.height(50.dp)
                                       .width(100.dp)
                                         ) {

                   
               }
           }

       }
    }
}

@Composable
private fun CreateImageProfile() {
    Surface(
        modifier = Modifier
            .size(size = 150.dp)
            .padding(12.dp),
        border = BorderStroke(0.5.dp, Color.LightGray),
        shape = CircleShape,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
        elevation = 5.dp,
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