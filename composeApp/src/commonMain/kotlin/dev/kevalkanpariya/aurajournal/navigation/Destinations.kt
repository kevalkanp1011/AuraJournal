package dev.kevalkanpariya.aurajournal.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeDestination

@Serializable
data class NewRecordDestination(val audioRecordingPath: String, val audioAmplitudePath: String)

@Serializable
object SettingsDestination


@Serializable
object AnalyticsDestination