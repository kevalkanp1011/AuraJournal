package dev.kevalkanpariya.aurajournal.di

import android.content.Context
import dev.kevalkanpariya.aurajournal.usecase.MainActivityUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun initKoin(context: Context) = initKoin {
    androidContext(context)
    modules(androidKoinModules)
}

val androidKoinModules = module {
    singleOf(::MainActivityUseCase)
}