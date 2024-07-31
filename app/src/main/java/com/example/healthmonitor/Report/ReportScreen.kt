package com.example.healthmonitor.Report

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.healthmonitor.ui.theme.Blue1
import com.example.healthmonitor.ui.theme.CustomButtonNoIcon
import com.example.healthmonitor.ui.theme.Green1
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(stepsData: List<Int>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Weekly Health Report") }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                HealthChart(stepsData)
                Spacer(modifier = Modifier.padding(20.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    CustomButtonNoIcon(text = "Set Goals", color = Green1) {

                    }
                }
                HighlightScreen()

            }
        }
    )
}

@Composable
fun GoalScreen() {
    var value by remember {
        mutableStateOf("")
    }
    Text(text = "Steps Goals Per Day")
    OutlinedTextField(value = value , onValueChange = {})
    CustomButtonNoIcon(text = "Save Goals", color = Blue1) {
    }
}

@Composable
fun HealthChart(stepsData: List<Int>) {
    val context = LocalContext.current

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        factory = {
            LineChart(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                setBackgroundColor(resources.getColor(android.R.color.white))
                setDrawGridBackground(false)
                setDrawBorders(false)
                description.isEnabled = false

                val xAxis: XAxis = this.xAxis
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.setDrawGridLines(false)
                xAxis.setDrawAxisLine(false)
                xAxis.granularity = 1f
                xAxis.labelRotationAngle = -45f
                xAxis.valueFormatter = object : ValueFormatter() {
                    private val days = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                    override fun getFormattedValue(value: Float): String {
                        return days.getOrNull(value.toInt()) ?: value.toString()
                    }
                }

                val yAxisLeft: YAxis = this.axisLeft
                yAxisLeft.setDrawGridLines(false)
                yAxisLeft.setDrawAxisLine(false)

                val yAxisRight: YAxis = this.axisRight
                yAxisRight.isEnabled = false

                this.legend.isEnabled = false

                val data = generateChartData(context, stepsData)
                this.data = data
                invalidate()
            }
        }
    )
}

fun generateChartData(context: android.content.Context, stepsData: List<Int>): LineData {
    val entries = stepsData.mapIndexed { index, steps -> Entry(index.toFloat(), steps.toFloat()) }

    val dataSet = LineDataSet(entries, "Steps")
    dataSet.color = ContextCompat.getColor(context, android.R.color.holo_blue_dark)
    dataSet.setCircleColor(ContextCompat.getColor(context, android.R.color.holo_blue_dark))
    dataSet.lineWidth = 2f
    dataSet.circleRadius = 4f
    dataSet.setDrawValues(false)
    dataSet.setDrawFilled(true)
    dataSet.fillColor = ContextCompat.getColor(context, android.R.color.holo_blue_light)
    dataSet.mode = LineDataSet.Mode.CUBIC_BEZIER

    // Ensure the line is drawn
    dataSet.setDrawCircles(true)
    dataSet.setDrawCircleHole(false)
    dataSet.setDrawIcons(false)
    dataSet.setDrawHorizontalHighlightIndicator(false)
    dataSet.setDrawVerticalHighlightIndicator(false)

    return LineData(dataSet)
}

fun generateSampleData(): LineData {
    val entries = listOf(
        Entry(0f, 5000f),
        Entry(1f, 7000f),
        Entry(2f, 6000f),
        Entry(3f, 8000f),
        Entry(4f, 5500f),
        Entry(5f, 7500f),
        Entry(6f, 9000f)
    )

    val dataSet = LineDataSet(entries, "Steps")
    dataSet.color = android.R.color.white
    dataSet.setCircleColor(android.R.color.white)
    dataSet.lineWidth = 2f
    dataSet.circleRadius = 4f
    dataSet.setDrawValues(false)
    dataSet.setDrawFilled(true)
    dataSet.fillColor = android.R.color.white
    dataSet.mode = LineDataSet.Mode.CUBIC_BEZIER

    return LineData(dataSet)
}

@Composable
fun HighlightScreen() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        Card(colors = CardDefaults.cardColors(Blue1)) {
            Text(modifier=Modifier.padding(10.dp),text = "Total Steps a week ")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Card(colors = CardDefaults.cardColors(Blue1)) {
            Text(modifier=Modifier.padding(10.dp), text = "Walking distance a week")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Card(colors = CardDefaults.cardColors(Blue1)) {
            Text(modifier=Modifier.padding(10.dp), text = "Average steps per week")
        }

    }


}

@Preview
@Composable
fun ReportScreenView() {
    ReportScreen(stepsData = listOf(5000, 7000, 6000, 8000, 5500, 7500, 9000))
}


