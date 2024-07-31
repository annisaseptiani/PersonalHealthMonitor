package com.example.healthmonitor.PersonalInfo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthmonitor.R
import com.example.healthmonitor.ui.theme.Blue1
import com.example.healthmonitor.ui.theme.CaloryCard
import com.example.healthmonitor.ui.theme.CustomButtonNoIcon
import com.example.healthmonitor.ui.theme.CustomCard
import com.example.healthmonitor.ui.theme.Green1
import com.example.healthmonitor.ui.theme.RecommendationCard
import com.example.healthmonitor.ui.theme.SleepCard
import com.example.healthmonitor.ui.theme.StepCard
import com.example.healthmonitor.ui.theme.WaterCard

@Composable
fun HealthDataScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
        PersonalDataLayout()
        BMILayout()
    }
}

@Composable
fun PersonalDataLayout() {
    Column(Modifier.fillMaxSize()) {
        Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
            text = "Personal Health Data", color = Blue1, fontSize = 25.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        GenderLayout()
        Spacer(modifier = Modifier.padding(10.dp))
        HeightLayout()
        Spacer(modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            WeightCard()
            AgeCard()
        }
        Row(
            Modifier
                .padding(10.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            CustomButtonNoIcon(text = "Update", color = Green1) {

            }
        }
    }
}

@Composable
fun BMILayout() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), border = BorderStroke(1.dp, Blue1),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
        Row(
            Modifier
                .padding(10.dp)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "BMI Calculation", fontSize = 20.sp)
            Icon(painter = painterResource(id = R.drawable.accessibility_new_24px), contentDescription = "BMI Icon")
        }
        Row(
            Modifier
                .padding(10.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "12.3 ", textAlign = TextAlign.Center, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Blue1)
        }
        Text(modifier = Modifier.padding(10.dp), text = "A BMI Between 19 and 49 is considered healthy")
        SuggestionLayout()
        Spacer(modifier = Modifier.padding(30.dp))
    }
}

@Composable
fun SuggestionLayout() {
    Column(Modifier.padding(10.dp)) {
        Text(text = "Suggestion", fontSize = 18.sp)
        Row(
            Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            RecommendationCard(color = WaterCard, icon = R.drawable.water_drop_24px, text = "8L/day")
            RecommendationCard(color = SleepCard, icon = R.drawable.bed_24px, text = "8 hour/day")
        }
        Row(
            Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            RecommendationCard(color = StepCard, icon = R.drawable.footprint_24px, text = "8000 steps/day")
            RecommendationCard(color = CaloryCard, icon = R.drawable.local_fire_department_24px, text = "200 cal/day")
        }
    }
}

@Composable
fun GenderLayout() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        CustomCard(image = R.drawable.female_24px, isSelected = false, text = "Female") {

        }
        CustomCard(image = R.drawable.male_24px, isSelected = false, text = "Male") {
        }
    }
}

@Composable
fun WeightCard() {
    Card(
        modifier = Modifier
            .size(130.dp),
        border = BorderStroke(1.dp, Blue1),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            var currentValue by remember {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, text = "Weight (in kg)")
            OutlinedTextField(modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp), value = currentValue, onValueChange = {})
        }
    }
}

@Composable
fun AgeCard() {
    Card(
        modifier = Modifier
            .size(130.dp),
        border = BorderStroke(1.dp, Blue1),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            var currentValue by remember {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, text = "Age")
            OutlinedTextField(modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp), value = currentValue, onValueChange = {})
        }
    }
}

@Composable
fun HeightLayout() {
    var height by remember { mutableStateOf(172f) }
    Card(modifier = Modifier.padding(10.dp), border = BorderStroke(1.dp, Blue1),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Height (in cm)",
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Text(
                    text = height.toInt().toString(),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
            ForecastSlider(
                values = (100..220).map { it.toString() },
                value = height,
                onValueChange = { height = it }
            )
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }

}

@Composable
fun ForecastSlider(values: List<String>, value: Float, onValueChange: (Float) -> Unit) {
    val drawPadding = with(LocalDensity.current) { 10.dp.toPx() }
    val textSize = with(LocalDensity.current) { 10.dp.toPx() }
    val lineHeightDp = 15.dp
    val lineHeightPx = with(LocalDensity.current) { lineHeightDp.toPx() }
    val canvasHeight = 50.dp
    val textPaint = android.graphics.Paint().apply {
        color = if (isSystemInDarkTheme()) 0xffffffff.toInt() else 0xff47586B.toInt()
        textAlign = android.graphics.Paint.Align.CENTER
        this.textSize = textSize
    }
    Box(contentAlignment = Alignment.Center) {
        Canvas(
            modifier = Modifier
                .height(canvasHeight)
                .fillMaxWidth()
                .padding(
                    top = canvasHeight
                        .div(5)
                        .minus(lineHeightDp.div(2))
                )
        ) {
            val yStart = 0f
            val distance = (size.width.minus(2 * drawPadding)).div(values.size.minus(1))
            values.forEachIndexed { index, value ->
                drawLine(
                    color = Color.DarkGray,
                    start = Offset(x = drawPadding + index.times(distance), y = yStart),
                    end = Offset(x = drawPadding + index.times(distance), y = lineHeightPx)
                )
                if (index.rem(10) == 0) {
                    this.drawContext.canvas.nativeCanvas.drawText(
                        value,
                        drawPadding + index.times(distance),
                        size.height,
                        textPaint
                    )
                }
            }
        }
        Slider(
            modifier = Modifier.fillMaxWidth(),
            value = value - 100f,
            valueRange = 0f..(values.size - 1).toFloat(),
            steps = values.size - 2,
            onValueChange = {
                onValueChange(it + 100f)
            }
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun PersonalInfoPreview(){
    HealthDataScreen()
}