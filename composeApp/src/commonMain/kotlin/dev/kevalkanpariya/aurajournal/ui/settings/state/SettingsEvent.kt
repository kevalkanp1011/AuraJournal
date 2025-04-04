package dev.kevalkanpariya.aurajournal.ui.settings.state

import dev.kevalkanpariya.aurajournal.ui.components.emotion.EmotionType
import dev.kevalkanpariya.aurajournal.ui.home.state.Topic

sealed interface SettingsEvent {

    data class EmotionUpdate(val emotionType: EmotionType) : SettingsEvent

    sealed interface Topics : SettingsEvent {
        data class SelectedTopicAdd(val topic: Topic) : Topics
        data class SelectedTopicRemove(val topic: Topic) : Topics
        data class SavedTopicsAdd(val topic: Topic) : Topics
        data class IsAddingStatusChange(val status: Boolean) : Topics
        data class SearchQueryChanged(val query: String) : Topics
    }
}