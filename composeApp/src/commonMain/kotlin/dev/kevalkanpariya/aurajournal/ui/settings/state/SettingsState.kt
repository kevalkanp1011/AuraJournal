package dev.kevalkanpariya.aurajournal.ui.settings.state

import dev.kevalkanpariya.aurajournal.ui.components.emotion.EmotionType
import dev.kevalkanpariya.aurajournal.ui.components.emotion.Emotions
import dev.kevalkanpariya.aurajournal.ui.home.state.Topic

data class SettingsState(
    val emotions: List<Emotions> = emptyList(),
    val emotionType: EmotionType? = null,
    val selectedTopics: Set<Topic> = emptySet(),
    val savedTopics: Set<Topic> = emptySet(),
    val isAddingTopic: Boolean = false,
    val searchQuery: String = "",
)
