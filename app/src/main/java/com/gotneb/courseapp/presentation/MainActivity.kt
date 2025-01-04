package com.gotneb.courseapp.presentation

import android.os.Bundle
import androidx.compose.runtime.getValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gotneb.courseapp.presentation.screen.home.HomeScreen
import com.gotneb.courseapp.presentation.screen.home.HomeScreenViewModel
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourseAppTheme {
                val viewmodel = hiltViewModel<HomeScreenViewModel>()
                val state by viewmodel.state.collectAsStateWithLifecycle()

                HomeScreen(
                    state = state,
                )
            }
        }
    }
}