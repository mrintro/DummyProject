package com.example.dummyproject.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummyproject.domain.AlarmRepository
import com.example.dummyproject.model.AlarmEntity
import com.example.dummyproject.model.UIEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.LocalTime

class AddAlarmViewModel(
    private val repository: AlarmRepository
): ViewModel() {


    private val setTime = MutableStateFlow<LocalTime>(LocalTime.now())
    val hour = MutableStateFlow(LocalTime.now().hour)
    val minute = MutableStateFlow(LocalTime.now().minute)
    val description = ObservableField("")
    private val _uiEvent = MutableLiveData<Event<UIEvent>>()
    val uiEvent : LiveData<Event<UIEvent>> = _uiEvent

    fun addAlarm() {
        viewModelScope.launch {
            val selectedHour = hour.value
            val selectedMinute = minute.value

            Log.d("Add Alarm", "Time: ${selectedHour}, ${selectedMinute}, description: ${description.get()}")

            val addAlarmRequestObject = AlarmEntity(
                hour = selectedHour,
                minutes = selectedMinute,
                description = description.get() ?: ""
            )
            addAlarm(addAlarmRequestObject)
        }
    }

    private suspend fun addAlarm(alarmRequest: AlarmEntity) {
        withContext(Dispatchers.IO) {
            try {
                repository.addAlarm(alarmRequest)
                _uiEvent.postValue(Event(UIEvent.NavigateToHome))
            } catch (e: Exception) {
                Log.e("AddAlarmViewModel", "Failed to add alarm")
            }
        }
    }

}