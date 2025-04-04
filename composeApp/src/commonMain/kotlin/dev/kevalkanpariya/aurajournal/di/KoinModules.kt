package dev.kevalkanpariya.aurajournal.di

import dev.kevalkanpariya.aurajournal.data.datasource.AudioLocalDatasource
import dev.kevalkanpariya.aurajournal.data.datasource.AudioLocalDatasourceImpl
import dev.kevalkanpariya.aurajournal.data.repository.AudioRepository
import dev.kevalkanpariya.aurajournal.data.repository.AudioRepositoryImpl
import dev.kevalkanpariya.aurajournal.platform.environment.Environment
import dev.kevalkanpariya.aurajournal.platform.permission.service.PermissionService
import dev.kevalkanpariya.aurajournal.platform.permission.service.PermissionServiceImpl
import dev.kevalkanpariya.aurajournal.ui.home.HomeViewModel
import dev.kevalkanpariya.aurajournal.ui.newrecord.NewRecordViewModel
import dev.kevalkanpariya.aurajournal.ui.settings.SettingsViewModel
import io.github.vyfor.groqkt.GroqClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            provideViewModelModule,
            providePermissionModule,
            provideDataSourceModule,
            provideRepositoryModule,
            provideNetworkModule,
            provideAudioPlayerModule(),
            providePermissionsModule(),
            provideAudioRecordModule(),
            provideStorageManager(),
            provideStorageModule(),
            provideFileManagerModule(),
            provideEnvironmentModule(),
        )
    }

val provideViewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::NewRecordViewModel)
    viewModelOf(::SettingsViewModel)
}

private val providePermissionModule = module {
    singleOf(::PermissionServiceImpl) bind PermissionService::class
}

val provideDataSourceModule = module {
    singleOf(::AudioLocalDatasourceImpl).bind(AudioLocalDatasource::class)
}

val provideRepositoryModule = module {
    singleOf(::AudioRepositoryImpl).bind(AudioRepository::class)
}

val provideNetworkModule = module {
    single { createJson() }
    single { createHttpClient(get(), true) }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

fun createHttpClient(json: Json, enableNetworkLogs: Boolean) = HttpClient {
    install(ContentNegotiation) {
        json(json)
    }
    if (enableNetworkLogs) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.NONE
        }
    }
}

fun createGroqClient(environment: Environment): GroqClient {
    return GroqClient(apiKey = environment.getApiKey())
}