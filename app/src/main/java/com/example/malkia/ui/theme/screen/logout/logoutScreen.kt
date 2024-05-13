package com.example.malkia.ui.theme.screen.logout

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.malkia.R
import java.lang.reflect.Modifier


@Composable
fun LogoutScreen(onLogout: () -> Unit) {
    Surface(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Layout.Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.logout_message),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(
                    onClick = onLogout,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = stringResource(id = R.string.logout))
                }
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
fun LogoutScreenPreview() {
    LogoutScreen (rememberNavController())
}