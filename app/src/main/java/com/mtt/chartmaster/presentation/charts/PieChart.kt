package com.mtt.chartmaster.presentation.charts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData

@Composable
fun PieChartScreen() {

        val pieChartData = PieChartData(
            slices = listOf(
                PieChartData.Slice(
                    label = "SciFi",
                    value = 40f,
                    color = Color(0xFF333333)
                ),
                PieChartData.Slice(
                    label = "Comedy",
                    value = 10f,
                    color = Color(0xFF334563)
                ),
                PieChartData.Slice(
                    label = "Thriller",
                    value = 30f,
                    color = Color(0xFF335533)
                ),
                PieChartData.Slice(
                    label = "Action",
                    value = 30f,
                    color = Color(0xFF312333)
                ),
            ),
            plotType = PlotType.Pie
        )
        val pieChartConfig = PieChartConfig(
            isAnimationEnable = true,
            showSliceLabels = true,
            activeSliceAlpha = 0.5f,
            animationDuration = 600
        )
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Pie Chart", modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp))
        PieChart(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            pieChartData = pieChartData,
            pieChartConfig = pieChartConfig
        )
    }
}