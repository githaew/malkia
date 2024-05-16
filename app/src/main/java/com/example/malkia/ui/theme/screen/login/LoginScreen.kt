package com.example.malkia.ui.theme.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.malkia.navigation.ROUTE_REGISTER_SCREEN


@Composable
fun LoginScreen(navController:NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var context= LocalContext.current
   

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Layout.Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
               navController.navigate(ROUTE_REGISTER_SCREEN)
            },
            modifier = Modifier
                .fillMaxSize()
                .height(50.dp)
        ) {
            Text("Login", fontSize = 18.sp)
        }
    }
}




//@Composable
//fun EmailIcon(
//    modifier: Modifier = Modifier,
//    iconSize: Dp,
//    iconColor: Color
//) {
//    Icon(
//        imageVector = Icons.Default.Email,
//        contentDescription = "Email Icon",
//        modifier = modifier.size(iconSize),
//        tint = iconColor
//    )
//}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(rememberNavController())
}