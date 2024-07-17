package com.example.dummyproject.data

import com.example.dummyproject.domain.AlarmRepository
import com.example.dummyproject.model.AlarmEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class AlarmRepositoryImpl(
    private val localDataSource: LocalDataSource
): AlarmRepository {
    override fun getAlarmList(): Flow<List<AlarmEntity>> =
        flow {
            emit(localDataSource.getAlarmList())
        }

    override fun addAlarm(alarmEntity: AlarmEntity) {
        localDataSource.addAlarm(alarmEntity)
    }
}