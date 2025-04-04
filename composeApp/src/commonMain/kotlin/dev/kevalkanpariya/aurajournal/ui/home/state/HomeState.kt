package dev.kevalkanpariya.aurajournal.ui.home.state

import androidx.compose.runtime.Stable
import dev.kevalkanpariya.aurajournal.data.model.Audio
import dev.kevalkanpariya.aurajournal.data.model.AudioPath
import dev.kevalkanpariya.aurajournal.ui.home.components.chips.FilterOption

@Stable
data class HomeState(
    val recordings: List<Recordings> = emptyList(),
    val moodChip: FilterOption? = null,
    val topicsChip: FilterOption? = null,
    val fabBottomSheet: HomeEvent.FabBottomSheet = HomeEvent.FabBottomSheet.SheetHide,
    val recordingPath: AudioPath? = null,
    val amplitudePath: String? = null,
)

sealed interface Recordings {
    data class Date(val date: String) : Recordings
    data class Entry(val recordings: List<Audio>) : Recordings
}