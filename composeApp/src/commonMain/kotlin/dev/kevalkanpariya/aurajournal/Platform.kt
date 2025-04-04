package dev.kevalkanpariya.aurajournal

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform