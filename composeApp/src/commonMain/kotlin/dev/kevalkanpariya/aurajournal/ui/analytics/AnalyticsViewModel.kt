package dev.kevalkanpariya.aurajournal.ui.analytics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.kevalkanpariya.aurajournal.data.model.Audio
import dev.kevalkanpariya.aurajournal.data.repository.AudioRepository
import dev.kevalkanpariya.aurajournal.ui.components.emotion.EmotionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AnalyticsViewModel(
    private val repository: AudioRepository,
): ViewModel() {

    private val _recordings = MutableStateFlow<List<Audio>>(emptyList())
    val recordings = _recordings
        .onStart { initRecordingsState() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    // filter by start and end date
    fun initRecordingsState() {
        viewModelScope.launch {

            val allRecordings: List<Audio> = repository.getAllRecordings()
            _recordings.update {
                allRecordings
            }
        }
    }

    fun getATInsights() {
        val textData = recordings.value.joinToString("\n") { it.description }
        val moodData = recordings.value.map { getMoodScore(it.emotionType) }
    }

    fun getMoodScore(emotionType: EmotionType): Double {
        return 0.0
    }



}