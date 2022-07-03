package com.picpay.desafio.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.picpay.desafio.android.design.theme.PicPayTheme
import com.picpay.desafio.android.navigation.core.NavCommand
import com.picpay.desafio.android.navigation.core.NavManager
import com.picpay.desafio.android.navigation.core.NavigationType
import com.picpay.desafio.android.navigation.graph.AppNavigation

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            PicPayTheme {
                ObserveNavManager(
                    navManager = viewModel.navManager,
                    navController = navController
                )
                AppNavigation(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController
                )
            }
        }
    }
}

@Composable
private fun ObserveNavManager(
    navManager: NavManager,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        navManager.commands.collect { navCommand ->
            when (navCommand) {
                is NavCommand.Navigate -> navigateByType(navController, navCommand)
                is NavCommand.NavigateUp -> navController.navigateUp()
                is NavCommand.PopStackBack -> navController.popBackStack()
            }
        }
    }
}

private fun navigateByType(
    navController: NavHostController,
    navCommand: NavCommand.Navigate
) {
    when (val type = navCommand.type) {
        is NavigationType.NavigateTo -> navController.navigate(
            route = navCommand.destination,
            navOptions = navCommand.navOptions
        )
        is NavigationType.PopUpTo -> navController.popBackStack(
            route = navCommand.destination,
            inclusive = type.inclusive
        )
    }
}
