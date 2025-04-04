package dev.kevalkanpariya.aurajournal.ui.home.components.appbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Leaderboard
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import aurajournal.composeapp.generated.resources.Res
import aurajournal.composeapp.generated.resources.home_appbar_title
import aurajournal.composeapp.generated.resources.settings_cd
import dev.kevalkanpariya.aurajournal.ui.theme.Secondary90
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    modifier: Modifier = Modifier,
    onSettingsClick: () -> Unit,
    onAnalyticsClick: () -> Unit,
) {

    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(Res.string.home_appbar_title),
                style = MaterialTheme.typography.headlineLarge,
            )
        },
        actions = {
            IconButton(
                onClick = onSettingsClick,
                content = {
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        contentDescription = stringResource(Res.string.settings_cd),
                        tint = Color.Unspecified,
                    )
                }
            )

            IconButton(
                onClick = onAnalyticsClick,
                content = {
                    Icon(
                        imageVector = Icons.Outlined.Leaderboard,
                        contentDescription = stringResource(Res.string.settings_cd),
                        tint = Color.Unspecified,
                    )
                }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Secondary90
        )
    )
}