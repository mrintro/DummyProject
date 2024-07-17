package com.example.dummyproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dummyproject.dao.AlarmDao
import com.example.dummyproject.model.AlarmEntity


@Database(
    entities = [AlarmEntity::class],
    version = 1
)
abstract class AlarmDatabase: RoomDatabase() {
    abstract fun alarmDao(): AlarmDao

    companion object {
        @Volatile
        private var _instance: AlarmDatabase? = null

        private const val databaseName = "alarm_table"

        fun getInstance(context: Context) = _instance ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                AlarmDatabase::class.java,
                databaseName
            ).build()
            _instance = instance
            return instance
        }

    }

}