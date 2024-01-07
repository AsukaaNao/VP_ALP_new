package com.example.vp_alp_new.ui.view

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.Scaffold
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment


import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vp_alp.R
import com.example.vp_alp_new.data.loadNear
import com.example.vp_alp_new.ui.theme.colorPrimary



@OptIn(ExperimentalMaterial3Api::class)
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
        ) { section ->
            when (section) {
                DashboardSection.Home -> HomeView(loadNear())
                DashboardSection.Search -> SearchingScreen(loadNear())
//                DashboardSection.Search -> SearchingScreen(navController)
                DashboardSection.Favorite -> LikedListView(loadNear())
                DashboardSection.Profile -> AccountView()
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
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = contentColorFor(MaterialTheme.colorScheme.background)
    ) {
        items.forEach { section ->
            val selected = section == currentSection
            val iconRes = if (selected) section.selectedIcon else section.icon
            val iconColor = if (selected) colorPrimary else Color.Gray // Determine icon color

            BottomNavigationItem(
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = iconRes),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "Bottom nav icons",
                            tint = iconColor // Apply the determined color as tint
                        )
                        Text(
                            text = section.name,
                            color = if (selected) colorPrimary else Color.Gray
                        )
                    }
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

enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int,
) {
    Home(R.drawable.baseline_home_24, R.drawable.baseline_home_24),
    Search(R.drawable.baseline_search_24, R.drawable.baseline_search_24),
    Favorite(R.drawable.baseline_favoriteblck_24, R.drawable.baseline_favoriteblck_24),
    Profile(R.drawable.baseline_person_24, R.drawable.baseline_person_24),
}