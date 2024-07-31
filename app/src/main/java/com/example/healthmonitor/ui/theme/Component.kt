package com.example.healthmonitor.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R

@Composable
fun CustomTextField(modifier: Modifier, onTextChange : (text: String) -> Unit, label: String,
                    idIcon: ImageVector, hint:String, isNumber:Boolean) {
    var currentValue by remember {
        mutableStateOf("")
    }
    TextField(modifier = modifier,
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChange(it) },
        leadingIcon = {
                Icon(imageVector = idIcon, contentDescription = "Text Icon") },
        label = { Text(text = label)},
        placeholder = {
            Text(text = hint, fontSize = 16.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 16.sp),
        keyboardOptions = if (isNumber) KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number) else KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun CustomButtonNoIcon(text: String, color: Color, onClick: () -> Unit) {
    Button(modifier = Modifier
        .wrapContentWidth(align = Alignment.CenterHorizontally), shape = RoundedCornerShape(40),
        colors = ButtonDefaults.buttonColors(containerColor = color), onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}

@Composable
fun CustomLinearProgressBar(
    progress: Float,
    max: Float,
    modifier: Modifier = Modifier,
    progressColor: Color = ProgressColor,
    backgroundColor: Color = BackProgressColor,
    cornerRadius: Float = 8f
) {
    Box(
        modifier = modifier
            .height(10.dp)
            .fillMaxWidth()
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Draw background
            drawRoundRect(
                color = backgroundColor,
                size = Size(size.width, size.height),
                cornerRadius = CornerRadius(cornerRadius, cornerRadius)
            )
            // Draw progress
            val progressWidth = (progress / max) * size.width
            drawRoundRect(
                color = progressColor,
                size = Size(progressWidth, size.height),
                cornerRadius = CornerRadius(cornerRadius, cornerRadius)
            )
        }
    }
}

@Composable
fun CustomCard(image:Int, isSelected: Boolean, text: String,
               onClick: ()->Unit,) {
    val localfocusManager = LocalFocusManager.current
    Card(
        modifier = Modifier
            .size(150.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (isSelected) Green1 else Blue1,
                    shape = RoundedCornerShape(8.dp)
                )){
            Image( modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxSize()
                .clickable {
                    localfocusManager.clearFocus()
                },
                painter = painterResource(id = image), contentDescription = null)
            Text(modifier = Modifier.align(Alignment.BottomCenter), text = text, fontSize = 20.sp)
        }

    }
}

@Composable
fun RecommendationCard(color: Color, icon : Int, text:String) {
    Card(colors = CardDefaults.cardColors(containerColor = color)) {
        Column(Modifier.size(100.dp), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "icon"

            )
            Text(text = text)
        }

    }
}


