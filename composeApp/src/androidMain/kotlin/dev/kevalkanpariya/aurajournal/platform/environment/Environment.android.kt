package dev.kevalkanpariya.aurajournal.platform.environment

import dev.kevalkanpariya.aurajournal.BuildConfig

actual class Environment {
    actual fun getApiKey(): String = BuildConfig.GROQ
}