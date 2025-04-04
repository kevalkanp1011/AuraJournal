package dev.kevalkanpariya.aurajournal

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dev.kevalkanpariya.aurajournal.data.model.AudioPath
import dev.kevalkanpariya.aurajournal.navigation.AnalyticsDestination
import dev.kevalkanpariya.aurajournal.navigation.HomeDestination
import dev.kevalkanpariya.aurajournal.navigation.NewRecordDestination
import dev.kevalkanpariya.aurajournal.navigation.SettingsDestination
import dev.kevalkanpariya.aurajournal.ui.analytics.AnalyticsScreen
import dev.kevalkanpariya.aurajournal.ui.home.HomeScreen
import dev.kevalkanpariya.aurajournal.ui.newrecord.NewRecordScreen
import dev.kevalkanpariya.aurajournal.ui.settings.SettingsScreen
import dev.kevalkanpariya.aurajournal.ui.theme.FlowTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController(),
    widgetOpenRecord: Boolean = false
) {
    FlowTheme {

        NavHost(
            navController = navController,
            startDestination = HomeDestination,
        ) {

            composable<HomeDestination> {
                HomeScreen(
                    widgetOpenRecord = widgetOpenRecord,
                    onNewRecordClick = { path, amplitudePath ->
                        navController.navigate(
                            NewRecordDestination(
                                audioRecordingPath = path.value,
                                audioAmplitudePath = amplitudePath
                            )
                        )
                    },
                    onSettingsClick = { navController.navigate(SettingsDestination) },
                    onAnalyticsClick = {navController.navigate(AnalyticsDestination) }
                )
            }

            composable<NewRecordDestination> {
                val args = it.toRoute<NewRecordDestination>()
                NewRecordScreen(
                    navController = navController,
                    path = AudioPath(args.audioRecordingPath),
                    amplitudePath =  args.audioAmplitudePath,
                )
            }

            composable<SettingsDestination> {
                SettingsScreen(onBackClick = { navController.navigateUp() })
            }

            composable<AnalyticsDestination> {
                AnalyticsScreen(onBackClick = { navController.navigateUp() })
            }
        }
    }
}
