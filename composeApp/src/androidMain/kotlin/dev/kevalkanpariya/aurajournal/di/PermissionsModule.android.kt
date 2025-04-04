package dev.kevalkanpariya.aurajournal.di

import dev.kevalkanpariya.aurajournal.platform.permission.Permission
import dev.kevalkanpariya.aurajournal.platform.permission.delegate.PermissionDelegate
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual fun providePermissionsModule() = module {
    single<PermissionDelegate>(named(Permission.MICROPHONE.name)) {
        PermissionDelegate(get())
    }
}