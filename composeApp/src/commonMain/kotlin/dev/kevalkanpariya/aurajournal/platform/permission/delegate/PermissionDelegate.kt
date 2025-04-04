package dev.kevalkanpariya.aurajournal.platform.permission.delegate

import dev.kevalkanpariya.aurajournal.platform.permission.PermissionState

expect class PermissionDelegate {
    suspend fun getPermissionState(): PermissionState
    suspend fun providePermission()
    fun openSettingPage()
}
