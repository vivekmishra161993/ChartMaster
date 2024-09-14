package com.mtt.chartmaster.presentation

sealed class Screens(val route: String) {
    data object LineChartScreen : Screens("line_chart")
    data object HomeScreen : Screens("home")
    data object PieChartScreen : Screens("pie_chart")
    data object BarChartScreen : Screens("bar_chart")
}