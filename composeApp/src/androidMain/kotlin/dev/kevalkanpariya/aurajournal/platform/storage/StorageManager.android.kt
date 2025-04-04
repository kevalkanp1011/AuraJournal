package dev.kevalkanpariya.aurajournal.platform.storage

import dev.kevalkanpariya.aurajournal.usecase.MainActivityUseCase
import dev.kevalkanpariya.aurajournal.util.Constants
import kotlinx.io.files.Path

actual class StorageManager(
    private val mainActivityUseCase: MainActivityUseCase,
) {
    actual fun getStorageDir() =
        Path("${mainActivityUseCase.requireActivity().filesDir.path}${Constants.STORAGE_FILE_NAME}")
}
