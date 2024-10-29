package com.example.childrenstherapy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.childrenstherapy.ui.theme.ChildrensTherapyTheme
import com.example.childrenstherapy.ui.theme.ChildrensTherapyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChildrensTherapyTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Ronald",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var helloEmoji by remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(24.dp)

    ) {
        Button(
            onClick = { helloEmoji = true },
            modifier = Modifier.padding(24.dp)
        ) {
            Text(text = "Hi, my name is $name!")
        }

        if (helloEmoji) {
            Image(
                painter = rememberAsyncImagePainter(model = R.raw.hello_emoji),
                contentDescription = "Hello Emoji GIF",
                modifier = Modifier.size(150.dp)
            )
        }

    }
}

@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    ChildrensTherapyTheme() {
        Greeting("Android")
    }
}