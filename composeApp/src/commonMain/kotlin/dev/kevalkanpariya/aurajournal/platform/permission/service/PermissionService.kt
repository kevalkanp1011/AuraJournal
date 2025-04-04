package dev.kevalkanpariya.aurajournal.platform.permission.service

import dev.kevalkanpariya.aurajournal.platform.permission.Permission
import dev.kevalkanpariya.aurajournal.platform.permission.PermissionState
import kotlinx.coroutines.flow.Flow

interface PermissionService {
    suspend fun checkPermission(permission: Permission): PermissionState
    fun checkPermissionFlow(permission: Permission): Flow<PermissionState>
    suspend fun providePermission(permission: Permission)
    fun openSettingsPage(permission: Permission)
}
