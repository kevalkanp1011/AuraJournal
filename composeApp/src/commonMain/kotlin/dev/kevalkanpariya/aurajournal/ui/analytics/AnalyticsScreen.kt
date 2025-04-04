package dev.kevalkanpariya.aurajournal.ui.analytics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aay.compose.baseComponents.model.LegendPosition
import com.aay.compose.donutChart.PieChart
import com.aay.compose.donutChart.model.PieChartData
import com.aay.compose.lineChart.LineChart
import com.aay.compose.lineChart.model.LineParameters
import com.aay.compose.lineChart.model.LineType
import aurajournal.composeapp.generated.resources.Res
import aurajournal.composeapp.generated.resources.settings_cd
import dev.kevalkanpariya.aurajournal.ui.components.appbar.CenterTopAppBar
import dev.kevalkanpariya.aurajournal.ui.theme.Secondary90
import org.jetbrains.compose.resources.stringResource

@Composable
fun AnalyticsScreen(
    onBackClick: () -> Unit,
) {
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            //stringResource(Res.string.settings_appbar_title)
            CenterTopAppBar(
                text = "Analytics",
                contentDescription = stringResource(Res.string.settings_cd),
                containerColor = Secondary90,
                onBackClick = onBackClick,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            // Timeframe Toggle
            TimeframeToggle()

            Spacer(modifier = Modifier.height(16.dp))

            // Mood Summary Card
            MoodSummaryCard()

            Spacer(modifier = Modifier.height(16.dp))

            // Insights & Trends
            InsightsTrendsSection()

            Spacer(modifier = Modifier.height(16.dp))

            // AI Recommendations
            AIRecommendationsSection()

            Spacer(modifier = Modifier.height(16.dp))

            // Voice Note Highlights
            VoiceNoteHighlightsSection()
        }
    }

}

@Composable
fun TimeframeToggle() {
    var selectedOption by remember { mutableStateOf("Weekly") }
    val options = listOf("Weekly", "Monthly", "Yearly")
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        options.forEach { option ->
            Button(
                onClick = { selectedOption = option },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedOption == option) Color.Blue else Color.Gray
                )
            ) {
                Text(text = option, color = Color.White)
            }
        }
    }
}

@Composable
fun MoodSummaryCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Your Mood This Week", fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            PieChartView()
        }
    }
}

@Composable
fun PieChartView() {
    PieChart(
        pieChartData = listOf(
            PieChartData(data = 60.0, color = Color.Green, partName = "A"),
            PieChartData(data = 30.0, color = Color.Yellow, partName = "B"),
            PieChartData(data = 10.0, color = Color.Red, partName = "C")
        ),
        modifier = Modifier.fillMaxWidth().size(200.dp)

    )
}

@Composable
fun InsightsTrendsSection() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text("Patterns We Noticed 🧠", fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            LineChartView()

            Text("- 'Work meetings' mentioned 12 times this week.")
            Text("- Happiest after outdoor activities 🏞️.")
        }
    }
}

@Composable
fun LineChartView() {
    val lineParameters = listOf(
        LineParameters(
            label = "Mood Score",
            data = listOf(3.0, 4.5, 2.8, 5.0, 4.2),
            lineColor = Color.Blue,
            lineType = LineType.CURVED_LINE, // Assuming `LineType` has options like `Smooth`, `Dashed`, etc.
            lineShadow = true
        ),
        LineParameters(
            label = "Energy Level",
            data = listOf(2.0, 3.5, 3.0, 4.8, 5.0),
            lineColor = Color.Green,
            lineType = LineType.DEFAULT_LINE,
            lineShadow = false
        )
    )
    LineChart(
        modifier = Modifier
            .fillMaxWidth()
        ,
        linesParameters = lineParameters,
        xAxisData = listOf("happy", "sad", "excited", "swing", "out"),
        gridColor = Color.LightGray,
        showXAxis = true,
        showYAxis = true,
        isGrid = true,
        animateChart = true,
        //chartRatio = 1f, // Adjust as needed
        legendPosition = LegendPosition.BOTTOM
    )
}


@Composable
fun AIRecommendationsSection() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Suggestions for You 💡", fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text("- Try a 10-minute meditation for stress.")
            Text("- Revisit April 5 note—it was your happiest day! 🌟")
            Text("- Play this uplifting playlist 🎵")
        }
    }
}

@Composable
fun VoiceNoteHighlightsSection() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Memories of the Week 🎙️", fontSize = 18.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text("- 'I loved the sunset at the park...'")
            Text("- 'Finally finished that project! 🎉'")
        }
    }
}


