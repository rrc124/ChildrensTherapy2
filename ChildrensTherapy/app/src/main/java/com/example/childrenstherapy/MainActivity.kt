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
/*
Similar to int main() entry point in C++, but this is specific to Android app development.
"class MainActivity" is declared in the AndroidManifest.xml file.
Bundle, imported above, allows the app to save the activity and keep your state in the
program. With bundle, if your app is moved to the background, it will return to the state
you left it.  The syntax class_name : other_class_name signifies MainActivity inherits all
methods from the other class, ComponentActivity.  Scaffold, a Jetpack Compose function,
provides UI layouts (such as having a title on top, a button in the bottom right, and a
bottom bar) and standard spacing.
https://www.geeksforgeeks.org/scaffold-in-android-using-jetpack-compose/?ref=header_outind
Placing the Scaffold function under setContent ensures it takes up the entire available
space.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ChildrensTherapyTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // Scaffold
                    Greeting(
                        name = "DevTeam",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
/*
A composable is a "nestable" function from Jetpack that allows you to create complex
UI structures. So "@Composable" tells the function "Greeting" to use the Jetpack
Compose UI framework.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var helloEmoji by remember { // var is mutable variable, vs val which is not.
        mutableStateOf(false)
    }
    /*
    Function "Column" arranges items vertically.  The function "Button" is placed within this column
    that shows "Hi, my name is ...".  When this button is clicked, the state of "helloEmoji" is set to
    true and a GIF emoji is displayed.
     */
    Column( // Function imported from import androidx.compose.foundation.layout.
        // Column gives Greeting a vertical layout.
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(24.dp) // Modifier function contains decorations and
        // behaviors to function Column.
        // https://www.geeksforgeeks.org/concept-of-padding-in-android/?ref=header_outind

    )
    /*
    Button is a Composable function that creates a clickable button UI.
    This function provides a string of text (Hi, my name is $name!"
    */
    {
        Button(
            onClick = { helloEmoji = true }, // Sets a boolean state to var "helloEmoji".
            // If Button is clicked, set "helloEmoji" to true.
            modifier = Modifier.padding(24.dp)
        ) {
            Text(text = "Hi, my name is $name!") // Text that shows inside the button.
        }

        // If "helloEmoji" is true, then display the GIF.
        if (helloEmoji) {
            Image(
                painter = rememberAsyncImagePainter(model = R.raw.hello_emoji),
                contentDescription = "Hello Emoji GIF",
                modifier = Modifier.size(150.dp)
            )
        }
    }
}
/*
@Preview allows us to preview the app inside of the Android Studio environment.
 */
@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    ChildrensTherapyTheme() {
        Greeting("Android")
    }
}