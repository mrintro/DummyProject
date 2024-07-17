package com.example.dummyproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummyproject.domain.AlarmRepository
import com.example.dummyproject.model.AlarmModel
import com.example.dummyproject.model.mapper.toAlarmModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.LocalTime

class AlarmListViewModel(
    val alarmRepository: AlarmRepository
): ViewModel() {

    private val _alarmModelList = MutableLiveData<List<AlarmModel>>()
    val alarmModelList: LiveData<List<AlarmModel>> = _alarmModelList

    fun getAlarmList() {
        viewModelScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                alarmRepository.getAlarmList().collect {
                    _alarmModelList.postValue(it.toAlarmModel())
                }
            }
        }
    }

}