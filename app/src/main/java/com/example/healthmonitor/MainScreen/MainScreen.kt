package com.example.healthmonitor.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmonitor.R
import com.example.healthmonitor.ui.theme.Blue1
import com.example.healthmonitor.ui.theme.CaloryCard
import com.example.healthmonitor.ui.theme.CustomButtonNoIcon
import com.example.healthmonitor.ui.theme.CustomLinearProgressBar
import com.example.healthmonitor.ui.theme.Green1
import com.example.healthmonitor.ui.theme.SleepCard
import com.example.healthmonitor.ui.theme.StepCard
import com.example.healthmonitor.ui.theme.TextColor
import com.example.healthmonitor.ui.theme.WaterCard
import com.example.healthmonitor.ui.theme.WeatherCard

@Composable
fun MainScreen() {
    Column {
        Spacer(modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            MainScreenTop(greeting = "Good Evening", name = "Anna", message = "Hope You Well")
            Spacer(modifier = Modifier.padding(5.dp))
            WeatherLayout()
        }
        StepLayout()
        SleepLayout()
        WaterLayout()
        CaloriesLayout()
    }
}

@Composable
fun MainScreenTop(greeting : String, name : String, message: String) {
    Column {
        Text(text = "$greeting, $name!", fontSize = 30.sp, color = Blue1 )
        Text(text = message, fontSize = 30.sp, color = Green1)
    }

}

@Composable
fun WeatherLayout() {
    Card(modifier = Modifier
        .fillMaxWidth(), shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors(containerColor = WeatherCard)) {
        Column(modifier = Modifier.padding(3.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(id = R.drawable.light_mode_24px), contentDescription = "weather icon")
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "Sunny", color = TextColor)
            }
            Row {
                Text(text = "Don't forget to use sunscreen!", color = TextColor)
            }
        }
    }

}

@Composable
fun StepLayout() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), shape = RoundedCornerShape(30),
        colors = CardDefaults.cardColors(containerColor = StepCard)) {
        Column {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Card(modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 30.dp, top = 10.dp), shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Icon(modifier = Modifier
                        .size(40.dp)
                        .padding(5.dp), painter = painterResource(id = R.drawable.directions_walk_24px), contentDescription = "Walk Icon")
                }
                Text(text = "100/1000", Modifier.padding(end = 30.dp, top = 10.dp), color = TextColor)
            }
            Row(Modifier.padding(start = 30.dp, end = 30.dp, top = 10.dp)) {
                CustomLinearProgressBar(progress = 40f, max = 100f)
            }
            Text(modifier = Modifier.padding(start=30.dp, top = 10.dp),
                text = "You are walking 1000 steps today", color = TextColor)
            Text(modifier = Modifier.padding(start = 30.dp, top=10.dp),
                text = "Suggestion = Take more walk!", color = TextColor)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun SleepLayout() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), shape = RoundedCornerShape(30),
        colors = CardDefaults.cardColors(containerColor = SleepCard)) {
        Column {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Card(modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 30.dp, top = 10.dp), shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Icon(modifier = Modifier
                        .size(40.dp)
                        .padding(5.dp), painter = painterResource(id = R.drawable.bedtime_24px), contentDescription = "Walk Icon")
                }
                Text(text = "100/1000", Modifier.padding(end = 30.dp, top = 10.dp), color = TextColor)
            }
            Row(Modifier.padding(start = 30.dp, end = 30.dp, top = 10.dp)) {
                CustomLinearProgressBar(progress = 40f, max = 100f)
            }
            Text(modifier = Modifier.padding(start=30.dp, top = 10.dp),
                text = "You sleep 8 hour today", color = TextColor)
            Text(modifier = Modifier.padding(start = 30.dp, top=10.dp),
                text = "You have enough sleep", color = TextColor)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun WaterLayout() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), shape = RoundedCornerShape(30),
        colors = CardDefaults.cardColors(containerColor = WaterCard)) {
        Column {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Card(modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 30.dp, top = 10.dp), shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Icon(modifier = Modifier
                        .size(40.dp)
                        .padding(5.dp), painter = painterResource(id = R.drawable.glass_cup_24px), contentDescription = "Walk Icon")
                }
                Text(text = "100/1000", Modifier.padding(end = 30.dp, top = 10.dp), color = TextColor)
            }
            Row(Modifier.padding(start = 30.dp, end = 30.dp, top = 10.dp)) {
                CustomLinearProgressBar(progress = 40f, max = 100f)
            }
            Text(modifier = Modifier.padding(start=30.dp, top = 10.dp),
                text = "You drink 1 liter today", color = TextColor)
            Text(modifier = Modifier.padding(start = 30.dp, top=10.dp),
                text = "Suggestion = Grab your bottle!", color = TextColor)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun CaloriesLayout() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), shape = RoundedCornerShape(30),
        colors = CardDefaults.cardColors(containerColor = CaloryCard)) {
        Column {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Card(modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 30.dp, top = 10.dp), shape = CircleShape,
                    colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    Icon(modifier = Modifier
                        .size(40.dp)
                        .padding(5.dp), painter = painterResource(id = R.drawable.nutrition_24px), contentDescription = "Walk Icon")
                }
                Text(text = "100/1000", Modifier.padding(end = 30.dp, top = 10.dp), color = TextColor)
            }
            Row(Modifier.padding(start = 30.dp, end = 30.dp, top = 10.dp)) {
                CustomLinearProgressBar(progress = 40f, max = 100f)
            }
            Text(modifier = Modifier.padding(start=30.dp, top = 10.dp),
                text = "You drink 1 liter today", color = TextColor)
            Text(modifier = Modifier.padding(start = 30.dp, top=10.dp),
                text = "Suggestion = Grab your bottle!", color = TextColor)
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
MainScreen()
}