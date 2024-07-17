package com.example.dummyproject.model.mapper

import com.example.dummyproject.model.AlarmEntity
import com.example.dummyproject.model.AlarmModel
import java.time.LocalTime

fun List<AlarmEntity>.toAlarmModel(): List<AlarmModel> {
    return this.map {
        it.toAlarmModel()
    }
}

fun AlarmEntity.toAlarmModel() = AlarmModel(
    LocalTime.of(
        hour, minutes, 0
    ),
    description
)