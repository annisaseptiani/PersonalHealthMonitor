package com.example.healthmonitor.Register

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthmonitor.Login.LoginForm
import com.example.healthmonitor.R
import com.example.healthmonitor.ui.theme.Blue1
import com.example.healthmonitor.ui.theme.CustomButtonNoIcon
import com.example.healthmonitor.ui.theme.CustomTextField
import com.example.healthmonitor.ui.theme.Green1

@Composable
fun RegisterScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
            .background(Green1)) {
            RegisterForm()
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "OR")
            Spacer(modifier = Modifier.padding(5.dp))
            Button(onClick = { }, colors = ButtonDefaults.buttonColors(Blue1)) {
                Text(text = "Continue with Google", color = Color.White)
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Image(modifier = Modifier
            .fillMaxWidth().fillMaxHeight(), painter = painterResource(id = R.drawable.logo_health_monitor), contentDescription = "Logo")



    }
}

@Composable
fun RegisterForm() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        CustomTextField(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .border(width = 3.dp, color = Blue1, shape = RoundedCornerShape(10.dp)), onTextChange = {},
            idIcon = Icons.Outlined.Person, label = "Name", hint = "Input Name", isNumber = false)
        CustomTextField(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .border(width = 3.dp, color = Blue1, shape = RoundedCornerShape(10.dp)), onTextChange = {},
            idIcon = Icons.Outlined.Email, label = "Email", hint = "Input Email", isNumber = false)
        CustomTextField(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .border(width = 3.dp, color = Blue1, shape = RoundedCornerShape(10.dp)), onTextChange = {},
            idIcon = Icons.Outlined.Password, label = "Password", hint = "Input Password", isNumber = false)
        CustomButtonNoIcon(text = "Register", color = Blue1) {
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}