package com.mtt.chartmaster.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(modifier: Modifier, navController: NavController) {
    val chartTypes = listOf("Line Chart", "Bar Chart", "Pie Chart")
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(chartTypes) { item: String ->
            Button(onClick = {
                when (item) {
                    "Line Chart" -> navController.navigate(Screens.LineChartScreen.route)
                    "Bar Chart" -> navController.navigate(Screens.BarChartScreen.route)
                    "Pie Chart" -> navController.navigate(Screens.PieChartScreen.route)
                }
            }) {
                Text(text = item)
            }
        }
    }
}