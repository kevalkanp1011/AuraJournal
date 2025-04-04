package dev.kevalkanpariya.aurajournal.ui.newrecord.state

import androidx.compose.runtime.Stable
import dev.kevalkanpariya.aurajournal.data.model.AmplitudeData
import dev.kevalkanpariya.aurajournal.ui.components.emotion.EmotionType
import dev.kevalkanpariya.aurajournal.ui.components.emotion.Emotions
import dev.kevalkanpariya.aurajournal.ui.home.state.Topic
import kotlin.time.Duration

@Stable
data class NewRecordState(
    val title: String? = null,
    val emotionType: EmotionType? = null,
    val emotions: List<Emotions> = emptyList(),
    val selectedTopics: Set<Topic> = emptySet(),
    val savedTopics: Set<Topic> = emptySet(),
    val isAddingTopic: Boolean = false,
    val searchQuery: String = "",
    val description: String = "",
    val isAITranscribeUsed: Boolean = false,
    val amplitudeData: List<AmplitudeData> = emptyList(),
    val totalDuration: Duration? = null,
    val onBackConfirm: Boolean = false,
    val isEmotionSaveButtonEnabled: Boolean = false,
    val isSaveButtonEnabled: Boolean = false,
    val fabState: NewRecordEvent.FabBottomSheet = NewRecordEvent.FabBottomSheet.SheetHide,
)
