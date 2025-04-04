package dev.kevalkanpariya.aurajournal.di

import dev.kevalkanpariya.aurajournal.platform.environment.Environment
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun provideEnvironmentModule() = module {
    singleOf(::Environment)
}