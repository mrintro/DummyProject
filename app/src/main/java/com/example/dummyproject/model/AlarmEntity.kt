package com.example.dummyproject.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "alarm_hour") val hour: Int,
    @ColumnInfo(name = "alarm_minutes") val minutes: Int,
    @ColumnInfo(name = "alarm_description") val description: String
)
