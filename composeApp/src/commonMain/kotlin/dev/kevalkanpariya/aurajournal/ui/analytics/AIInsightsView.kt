package dev.kevalkanpariya.aurajournal.ui.analytics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aay.compose.lineChart.LineChart
import com.aay.compose.lineChart.model.LineParameters
import com.aay.compose.lineChart.model.LineType
import dev.kevalkanpariya.aurajournal.ui.home.state.Recordings

@Composable
fun AIInsightsView(
    recordings: List<Recordings>,
    startDate: Long,
    endDate: Long,
    selectedMood: String
) {

    var insights by remember { mutableStateOf("Generating insights...") }
    var lineChartData by remember { mutableStateOf(emptyList<Float>()) }

//    LaunchedEffect(startDate, endDate, selectedMood) {
//        // Update line chart data
//        lineChartData = moodData
//    }
//
//    Column {
//        Text(insights, modifier = Modifier.padding(16.dp))
//
//        // Line chart to show trends
//        LineChartView(data = lineChartData)
//    }


}

@Composable
fun LineChartView(data: List<Float>) {
    LineChart(
        linesParameters = listOf(
            LineParameters(
                label = "Mood Trend",
                data = data.map { it.toDouble() },
                lineColor = Color.Blue,
                lineType = LineType.DEFAULT_LINE,
                lineShadow = true
            )
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsightsScreen(
    recordings: List<Recordings>,
    startDate: Long,
    endDate: Long,
    selectedMood: String
) {
    var startDate by remember { mutableStateOf(0L) }
    var endDate by remember { mutableStateOf(0L) }
    var selectedMood by remember { mutableStateOf("Happy") }

    var state = rememberDateRangePickerState(initialSelectedStartDateMillis = startDate, initialSelectedEndDateMillis = endDate)

    Column {
        DateRangePicker(state = state)
        //MoodFilter { mood -> selectedMood = mood }
        AIInsightsView(recordings, startDate, endDate, selectedMood)
    }
}

