package dev.kevalkanpariya.aurajournal.di

import dev.kevalkanpariya.aurajournal.platform.audioplayer.AudioPlayer
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun provideAudioPlayerModule() = module {
    singleOf(::AudioPlayer)
}
