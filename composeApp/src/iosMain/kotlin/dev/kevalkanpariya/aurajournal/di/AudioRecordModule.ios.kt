package dev.kevalkanpariya.aurajournal.di

import dev.kevalkanpariya.aurajournal.platform.audiorecord.AudioRecorder
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun provideAudioRecordModule() = module {
    singleOf(::AudioRecorder)
}
