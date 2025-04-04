package dev.kevalkanpariya.aurajournal.platform.environment

actual class Environment {
    actual fun getApiKey(): String =
        platform.Foundation.NSProcessInfo.processInfo.environment["groq"] as String
}