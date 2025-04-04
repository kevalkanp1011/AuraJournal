package dev.kevalkanpariya.aurajournal.ui.home.components.empty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import aurajournal.composeapp.generated.resources.Res
import aurajournal.composeapp.generated.resources.home_empty_subtitle
import aurajournal.composeapp.generated.resources.home_empty_title
import aurajournal.composeapp.generated.resources.ic_empty
import dev.kevalkanpariya.aurajournal.ui.theme.spacing
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreenEmpty(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(Res.drawable.ic_empty),
            contentDescription = null,
        )

        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.large),
            text = stringResource(Res.string.home_empty_title),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.extraSmall),
            text = stringResource(Res.string.home_empty_subtitle),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}
