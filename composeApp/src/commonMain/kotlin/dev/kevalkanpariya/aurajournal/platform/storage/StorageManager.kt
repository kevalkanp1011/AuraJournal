package dev.kevalkanpariya.aurajournal.platform.storage

import kotlinx.io.files.Path

expect class StorageManager {
    fun getStorageDir(): Path
}
