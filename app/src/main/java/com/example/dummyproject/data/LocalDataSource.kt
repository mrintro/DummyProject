package com.example.dummyproject.data

import com.example.dummyproject.dao.AlarmDao
import com.example.dummyproject.model.AlarmEntity

class LocalDataSource(
    val alarmDao: AlarmDao
) {
    fun addAlarm(alarmEntity: AlarmEntity) {
        alarmDao.addAlarm(alarmEntity)
    }

    fun getAlarmList(): List<AlarmEntity> {
        return alarmDao.getAlarmList()
    }

}