package dev.kevalkanpariya.aurajournal.di

import  dev.kevalkanpariya.aurajournal.platform.storage.StorageManager
import dev.kevalkanpariya.aurajournal.data.model.AudioTable
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun provideStorageModule() = module {
    single<KStore<AudioTable>> {
        val storageManager: StorageManager = get()
        val directory = storageManager.getStorageDir()

        storeOf(
            file = directory,
            default = AudioTable()
        )
    }
}

actual fun provideStorageManager() = module {
    singleOf(::StorageManager)
}
