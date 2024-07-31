package com.example.healthmonitor.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthmonitor.R
import com.example.healthmonitor.ui.theme.Blue1
import com.example.healthmonitor.ui.theme.CustomButtonNoIcon
import com.example.healthmonitor.ui.theme.CustomTextField
import com.example.healthmonitor.ui.theme.Green1

@Composable
fun LoginWithEmailScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
            .background(Green1)) {
            Spacer(modifier = Modifier.padding(10.dp))
            LoginForm()
            Spacer(modifier = Modifier.padding(20.dp))
        }
        Column(modifier = Modifier.padding(top = 30.dp)) {
            Image(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), painter = painterResource(id = R.drawable.logo_health_monitor), contentDescription = "Logo")
        }


    }
}

@Composable
fun LoginForm() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        CustomTextField(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .border(width = 3.dp, color = Blue1, shape = RoundedCornerShape(10.dp)), onTextChange = {},
            idIcon = Icons.Outlined.Email, label = "Email", hint = "Input Email", isNumber = false)
        CustomTextField(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .border(width = 3.dp, color = Blue1, shape = RoundedCornerShape(10.dp)), onTextChange = {},
            idIcon = Icons.Outlined.Password, label = "Password", hint = "Input Passwor", isNumber = false)
        CustomButtonNoIcon(text = "Login", color = Blue1) {
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginWithEmailPreview() {
    LoginWithEmailScreen()
}