package com.gotneb.courseapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gotneb.courseapp.domain.util.BookmarkScreen
import com.gotneb.courseapp.domain.util.CourseDetailScreen
import com.gotneb.courseapp.domain.util.HomeScreen
import com.gotneb.courseapp.domain.util.MyCoursesScreen
import com.gotneb.courseapp.domain.util.Route
import com.gotneb.courseapp.domain.util.SearchScreen
import com.gotneb.courseapp.presentation.screen.bookmark.BookmarkScreen
import com.gotneb.courseapp.presentation.screen.bookmark.BookmarkScreenState
import com.gotneb.courseapp.presentation.screen.bookmark.BookmarkScreenViewModel
import com.gotneb.courseapp.presentation.screen.course_detail.CourseDetailViewModel
import com.gotneb.courseapp.presentation.screen.home.HomeScreen
import com.gotneb.courseapp.presentation.screen.home.HomeScreenViewModel
import com.gotneb.courseapp.presentation.screen.my_courses.MyCoursesScreen
import com.gotneb.courseapp.presentation.screen.my_courses.MyCoursesViewModel
import com.gotneb.courseapp.presentation.screen.search.SearchScreenViewModel
import com.gotneb.courseapp.presentation.ui.theme.CourseAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourseAppTheme {
                val navController = rememberNavController()

                var currentItem by remember { mutableStateOf(HomeScreen.name) }

                Scaffold(bottomBar = {
                    BottomNavigationBar(
                        navController,
                        onNavigate = { currentItem = it.name },
                        currentRoute = currentItem,
                    )
                }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreen,
                        Modifier.padding(innerPadding)
                    ) {
                        composable<HomeScreen> {
                            val viewModel = hiltViewModel<HomeScreenViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            HomeScreen(
                                state = state,
                                onSearchChange = viewModel::onQueryChange,
                                onCategorySelected = viewModel::onCategoryChange,
                                onCourseClick = { courseID ->
                                    navController.navigate(CourseDetailScreen(courseID))
                                },
                                onBookmarkClick = viewModel::bookmarkCourse,
                                onSearchClick = { query ->
                                    navController.navigate(SearchScreen(query))
                                },
                            )
                        }
                        composable<MyCoursesScreen> {
                            val viewModel = hiltViewModel<MyCoursesViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            MyCoursesScreen(
                                state = state,
                                onSearchChange = viewModel::onSearchTextChange,
                            )
                        }
                        composable<BookmarkScreen> {
                            val viewModel = hiltViewModel<BookmarkScreenViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            BookmarkScreen(
                                state = state,
                                onBookmarkClick = viewModel::bookmarkCourse,
                                onClick = { courseID ->
                                    navController.navigate(CourseDetailScreen(courseID))
                                },
                                onCategoryChange = viewModel::onCategoryChange,
                                onSearchClick = viewModel::onSearchFilter,
                                onValueChange = viewModel::onSearchTextChange,
                            )
                        }
                        composable<SearchScreen> {
                            val viewModel = hiltViewModel<SearchScreenViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            com.gotneb.courseapp.presentation.screen.search.SearchScreen(
                                state = state,
                                onValueChange = viewModel::onQueryChange,
                                onCourseClick = { id ->
                                    navController.navigate(CourseDetailScreen(id))
                                },
                                onReturnClick = { navController.popBackStack() },
                                onSearchClick = viewModel::onSearchClick,
                            )
                        }
                        composable<CourseDetailScreen> {
                            val viewModel = hiltViewModel<CourseDetailViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            com.gotneb.courseapp.presentation.screen.course_detail.CourseDetailScreen(
                                state = state,
                                onReturnClick = { navController.popBackStack() },
                                onBookmarkClick = viewModel::bookmarkCourse,
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun BottomNavigationBar(
        navController: NavController,
        onNavigate: (Route) -> Unit,
        currentRoute: String,
    ) {
        val navItems = listOf(
            NavItem("Home", Icons.Default.Home, HomeScreen),
            NavItem("Courses", Icons.Default.AccountCircle, MyCoursesScreen),
            NavItem("Bookmarks", Icons.Filled.Favorite, BookmarkScreen)
        )
        NavigationBar {
            val currentDestination = navController.currentDestination
            navItems.forEach { navItem ->
                println("Item name: ${navItem.route.name} | currentDestination: ${currentDestination?.route}")
                NavigationBarItem(selected = currentRoute == navItem.route.name,
                    onClick = {
                        navController.navigate(navItem.route)
                        onNavigate(navItem.route)
                    },
                    icon = { Icon(navItem.icon, contentDescription = null) },
                    label = { Text(navItem.label) })
            }
        }
    }
}