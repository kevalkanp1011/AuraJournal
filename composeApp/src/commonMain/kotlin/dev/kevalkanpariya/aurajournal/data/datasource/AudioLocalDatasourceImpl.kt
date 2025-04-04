package dev.kevalkanpariya.aurajournal.data.datasource

import arrow.core.raise.either
import dev.kevalkanpariya.aurajournal.data.mapper.toEmotionType
import dev.kevalkanpariya.aurajournal.data.model.AudioTable
import dev.kevalkanpariya.aurajournal.platform.filemanager.FileManager
import dev.kevalkanpariya.aurajournal.ui.components.emotion.EmotionType
import dev.kevalkanpariya.aurajournal.ui.home.state.Topic
import io.github.xxfast.kstore.KStore

class AudioLocalDatasourceImpl(
    private val storage: KStore<AudioTable>,
    private val fileManager: FileManager,
) : AudioLocalDatasource {
    override suspend fun insertRecording(audio: AudioTable.AudioData) {
        storage.update { state ->
            val newId = state?.recordings?.maxOfOrNull { it.id }?.plus(1) ?: 1L
            val newAudio = audio.copy(id = newId)
            state?.copy(recordings = state.recordings + newAudio)
        }
    }

    override suspend fun getRecordingById(id: Long): AudioTable.AudioData? {
        val recordings = storage.get()?.recordings ?: return null
        val recording = recordings.firstOrNull { it.id == id }
        return recording?.copy(
            path = getRecordingPath(recording.path),
            amplitudePath = getRecordingPath(recording.amplitudePath),
        )
    }

    override suspend fun getAllRecordings(): List<AudioTable.AudioData> {
        return storage.get()?.recordings
            ?.sortedWith(compareByDescending { it.createdDateInMillis })
            ?.map {
                it.copy(
                    path = getRecordingPath(it.path),
                    amplitudePath = getRecordingPath(it.amplitudePath)
                )
            } ?: emptyList()
    }

    override suspend fun deleteRecordings(recordings: List<AudioTable.AudioData>) {
        storage.update { state ->
            state?.copy(
                recordings = state.recordings.filterNot { recording -> recordings.any { it.id == recording.id } }
            )
        }
    }

    private suspend fun getRecordingPath(path: String): String {
        return either {
            with(fileManager) {
                this@either.getFullImagePath(path)
            }
        }.fold(
            ifLeft = { println("Failed to get recording path: $it"); path },
            ifRight = { return it }
        )
    }

    override suspend fun getDefaultEmotion(): EmotionType? {
        return storage.get()?.defaultEmotionType?.toEmotionType()
    }

    override suspend fun setDefaultEmotion(emotionType: EmotionType) {
        storage.update { state ->
            state?.copy(defaultEmotionType = emotionType.toEmotionType())
        }
    }

    override suspend fun getAllSelectedTopics(): Set<Topic> {
        return storage.get()?.defaultTopics ?: emptySet()
    }

    override suspend fun insertSelectedTopic(topic: Topic) {
        val allTopics = storage.get()?.defaultTopics?.toMutableSet()
        allTopics?.add(topic)
        storage.update { state ->
            state?.copy(defaultTopics = allTopics?.toSet() ?: state.defaultTopics)
        }
    }

    override suspend fun removeSelectedTopic(topic: Topic) {
        val allTopics = storage.get()?.defaultTopics?.toMutableSet()
        allTopics?.remove(topic)
        storage.update { state ->
            state?.copy(defaultTopics = allTopics?.toSet() ?: state.defaultTopics)
        }
    }

    override suspend fun getAllSavedTopics(): Set<Topic> {
        return storage.get()?.savedTopics ?: emptySet()
    }

    override suspend fun insertSavedTopic(topic: Topic) {
        val allTopics = storage.get()?.savedTopics?.toMutableSet()
        allTopics?.add(topic)
        storage.update { state ->
            state?.copy(savedTopics = allTopics?.toSet() ?: state.savedTopics)
        }
    }
}
