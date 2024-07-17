package com.example.dummyproject.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dummyproject.model.AlarmEntity

@Dao
interface AlarmDao {

    @Query("SELECT * from alarmentity")
    fun getAlarmList() : List<AlarmEntity>

    @Insert
    fun addAlarm(vararg alarmEntity: AlarmEntity)

}