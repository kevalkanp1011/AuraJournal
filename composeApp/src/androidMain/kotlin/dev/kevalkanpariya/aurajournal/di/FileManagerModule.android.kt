package dev.kevalkanpariya.aurajournal.di

import dev.kevalkanpariya.aurajournal.platform.filemanager.FileManager
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun provideFileManagerModule() = module {
    singleOf(::FileManager)
}