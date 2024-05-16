package com.example.malkia.ui.theme.screen.splash

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.malkia.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun SplashScreen(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(true) {
        coroutineScope.launch {
            delay(3000) // Simulate a delay of 3 seconds
            navController.navigate("home") // Navigate to the login screen
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,


        ) {

        Image(painter = painterResource(id = R.drawable.school), contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Welcome",
            color = Color.Green,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(20.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}