package com.example.healthmonitor.Landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthmonitor.R
import com.example.healthmonitor.ui.theme.Blue1
import com.example.healthmonitor.ui.theme.Green1

@Composable
fun LoginScreen(onSignInGoogleClick : () ->Unit, emailLoginClick :() -> Unit, 
                signUpClick : () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize().align(Alignment.TopCenter)) {
                Image(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.70f), painter = painterResource(id = R.drawable.logo_health_monitor), contentDescription = "Logo")
                Spacer(modifier = Modifier.padding(30.dp))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Green1)
                .align(Alignment.BottomCenter)) {
                Spacer(modifier = Modifier.padding(30.dp))
                Button(onClick = onSignInGoogleClick, colors = ButtonDefaults.buttonColors(Blue1)) {
                    Text(text = "Sign in with Email", color = Color.White)
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = onSignInGoogleClick, colors = ButtonDefaults.buttonColors(Blue1)) {
                    Text(text = "Sign in with Google", color = Color.White)
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row {
                    Text(text = "Don't have account?", color = Color.White)
                    Text(text = " Sign up", color= Color.White, textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.padding(30.dp))
            }

        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onSignInGoogleClick = { /*TODO*/ }, emailLoginClick = { /*TODO*/ }) {
        
    }
}