package com.mtt.chartmaster.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mtt.chartmaster.presentation.charts.BarChartScreen
import com.mtt.chartmaster.presentation.charts.LineChartScreen
import com.mtt.chartmaster.presentation.charts.PieChartScreen
import com.mtt.chartmaster.presentation.ui.theme.ChartMasterTheme
import com.mtt.chartmaster.presentation.ui.theme.Pink40
import com.mtt.chartmaster.presentation.ui.theme.Purple40
import com.mtt.chartmaster.presentation.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChartMasterTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Charts") },
                            colors = TopAppBarColors(
                                containerColor = Pink40,
                                scrolledContainerColor = Purple80,
                                navigationIconContentColor = Color.White,
                                titleContentColor = Color.White,
                                actionIconContentColor = Purple40
                            )
                        )
                    }
                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screens.HomeScreen.route,
                        modifier = Modifier.padding(top = innerPadding.calculateTopPadding()))
                    {
                        composable(route = Screens.HomeScreen.route) {
                            HomeScreen(
                                modifier = Modifier
                                    .padding(innerPadding.calculateTopPadding())
                                    .fillMaxSize(),navController)
                        }
                        composable(route = Screens.LineChartScreen.route) {
                            LineChartScreen()
                        }
                        composable(route = Screens.BarChartScreen.route) {
                            BarChartScreen()
                        }
                        composable(route = Screens.PieChartScreen.route) {
                            PieChartScreen()
                        }
                    }

                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ChartMasterTheme {
        //HomeScreen()
    }
}