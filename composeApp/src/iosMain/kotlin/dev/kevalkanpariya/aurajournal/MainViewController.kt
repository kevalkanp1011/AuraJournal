package dev.kevalkanpariya.aurajournal

import androidx.compose.ui.window.ComposeUIViewController
import dev.kevalkanpariya.aurajournal.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    },
    content = {
        App()
    }
)