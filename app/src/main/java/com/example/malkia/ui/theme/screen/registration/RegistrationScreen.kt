package com.example.malkia.ui.theme.screen.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.data.UiToolingDataApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.rememberNavController
import com.example.malkia.data.AuthViewModel
import com.example.malkia.navigation.ROUTE_LOGIN_SCREEN
import java.util.jar.Attributes


@Composable
fun RegisterScreen(navController: NavHostController) {
    val email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var stream by remember { mutableStateOf(TextFieldValue("")) }
    var title by remember { mutableStateOf(TextFieldValue("")) }

    val confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    val context= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Register here",
            color = Color.Black,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))


        TextField(
                    value = name,
                    onValueChange = {name = it},
                    //label = { Text(text = stringResource(id = R.string.name)) },
                    placeholder = {
                    Text(text = "Input Your Name")
                    },
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp)
                )
        Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = pass,
                    onValueChange = {pass = it},
                    //label = { Text(text = stringResource(id = R.string.password)) },
                    placeholder = {
                                  Text(text = "Input Password")
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 10.dp)
                    ,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
//                    keyboardActions = KeyboardActions(onDone = { onRegistration(username, password) })
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = stream,
                    onValueChange = {stream = it},
                    //label = { Text(text = stringResource(id = R.string.stream)) },
                    placeholder = {
                        Text(text = "Input Your Stram")
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 10.dp)

                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = title,
                    onValueChange = {title = it},
                   // label = { Text(text = stringResource(id = R.string.Book Title)) },
                    placeholder = {
                        Text(text = "Input Book Title")
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 10.dp)

                )



        Button(onClick = {
            val myregister= AuthViewModel(navController,context)
            myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())




        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register ")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN_SCREEN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Have an Account? Click to Login")
        }

    }



}

@Preview
@Composable
fun RegisterScreen() {
    RegisterScreen(rememberNavController())

}
