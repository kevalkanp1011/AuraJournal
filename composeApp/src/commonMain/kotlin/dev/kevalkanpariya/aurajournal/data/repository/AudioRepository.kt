package dev.kevalkanpariya.aurajournal.data.repository

import dev.kevalkanpariya.aurajournal.data.model.Audio
import dev.kevalkanpariya.aurajournal.ui.components.emotion.EmotionType
import dev.kevalkanpariya.aurajournal.ui.home.state.Topic

interface AudioRepository {

    suspend fun insertRecording(recording: Audio)

    suspend fun getRecordingById(id: Long): Audio?

    suspend fun getAllRecordings(): List<Audio>

    suspend fun deleteRecordings(recordings: List<Audio>)

    suspend fun getDefaultEmotion(): EmotionType?

    suspend fun setDefaultEmotion(emotionType: EmotionType)

    suspend fun getAllSelectedTopics(): Set<Topic>

    suspend fun insertSelectedTopic(topic: Topic)

    suspend fun removeSelectedTopic(topic: Topic)

    suspend fun getAllSavedTopics(): Set<Topic>

    suspend fun insertSavedTopic(topic: Topic)
}
