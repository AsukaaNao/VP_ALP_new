package com.example.vp_alp_new.ui.view

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Scaffold
//import androidx.compose.material.contentColorFor
//import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vp_alp.R
import com.example.vp_alp_new.ui.theme.colorPrimary

//import com.example.foodstore.ui.theme.colorPrimary
//import com.example.foodstore.R
//import com.example.foodstore.navigation.Screen

@Composable
fun Dashboard(
    navController: NavController,
) {
    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItems = DashboardSection.values().toList()

    Scaffold(
        bottomBar = {
            BottomBar(
                items = navItems,
                currentSection = sectionState.value,
                onSectionSelected = { sectionState.value = it },
            )
        }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier,
            targetState = sectionState.value,
            label = ""
        )
        { section ->
            when (section) {
                DashboardSection.Home -> HomeScreen(navController)
                else -> {}
            }
            when (section) {
                DashboardSection.List -> SearchingScreen(navController)
                else -> {}
            }
            when (section) {
                DashboardSection.Favorite -> PopularListScreen(navController)
                else -> {}
            }
            when (section) {
                DashboardSection.Profile -> ProfileScreen(navController)
                else -> {}
            }
        }
    }
}

@Preview
@Composable
fun DashboardPreview() = Dashboard(NavController(LocalContext.current))

@Composable
private fun BottomBar(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit,
) {
    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    ) {
        items.forEach { section ->

            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconRes),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "Bottom nav icons"
                    )
                },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = colorPrimary,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}
@Preview
@Composable
fun BottomBarPreview() = BottomBar(
    currentSection = DashboardSection.Home,
    items = DashboardSection.values().toList(),
) {}

private enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int,
) {
    Home(R.drawable.ic_home, R.drawable.ic_home),
    List(R.drawable.ic_search, R.drawable.ic_search),
    Favorite(R.drawable.ic_hearth, R.drawable.ic_hearth),
    Profile(R.drawable.ic_user, R.drawable.ic_user),
}