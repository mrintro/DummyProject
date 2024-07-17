package com.example.dummyproject.domain

import com.example.dummyproject.model.AlarmEntity
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {

    fun getAlarmList(): Flow<List<AlarmEntity>>
    fun addAlarm(alarmEntity: AlarmEntity)

}