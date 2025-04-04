package dev.kevalkanpariya.aurajournal.platform.permission.delegate

import android.Manifest
import dev.kevalkanpariya.aurajournal.platform.permission.Permission
import dev.kevalkanpariya.aurajournal.platform.permission.PermissionState
import dev.kevalkanpariya.aurajournal.usecase.MainActivityUseCase

actual class PermissionDelegate(
    private val mainActivityUseCase: MainActivityUseCase
) {
    actual suspend fun getPermissionState(): PermissionState {
        return checkPermissions(
            mainActivityUseCase.requireActivity(),
            mainActivityUseCase.requireActivity(),
            recordAudioPermissions,
        )
    }

    actual suspend fun providePermission() {
        mainActivityUseCase.requireActivity().providePermissions(recordAudioPermissions) {
            throw IllegalStateException("Cannot provide permission: ${Permission.MICROPHONE.name}")
        }
    }

    actual fun openSettingPage() {
        mainActivityUseCase.requireActivity().openAppSettingsPage(Permission.MICROPHONE)
    }

    private val recordAudioPermissions: List<String> = listOf(Manifest.permission.RECORD_AUDIO)

}