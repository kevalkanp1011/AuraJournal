package dev.kevalkanpariya.aurajournal.platform.filemanager

import arrow.core.raise.Raise
import dev.kevalkanpariya.aurajournal.data.model.AmplitudeData

expect class FileManager {
    suspend fun Raise<String>.getFullImagePath(relativePath: String): String
    suspend fun Raise<String>.getAmplitudeData(path: String): List<AmplitudeData>
}
