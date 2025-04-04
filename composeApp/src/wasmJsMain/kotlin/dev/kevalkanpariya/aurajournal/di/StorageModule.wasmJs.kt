package dev.kevalkanpariya.aurajournal.di

import  dev.kevalkanpariya.aurajournal.platform.storage.StorageManager
import dev.kevalkanpariya.aurajournal.data.model.AudioTable
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storage.storeOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun provideStorageManager() = module {
    single<KStore<AudioTable>> {
        storeOf("memes", AudioTable())
    }
}

actual fun provideStorageModule() = module {
    singleOf(::StorageManager)
}