package com.example.dummyproject

import android.app.Application
import androidx.room.RoomDatabase
import com.example.dummyproject.dao.AlarmDao
import com.example.dummyproject.data.AlarmRepositoryImpl
import com.example.dummyproject.data.LocalDataSource
import com.example.dummyproject.database.AlarmDatabase

class AlarmApplication: Application() {

    private val database by lazy {
        AlarmDatabase.getInstance(this)
    }
    private val localDataSource by lazy { LocalDataSource(alarmDao = database.alarmDao()) }
    val alarmRepository by lazy { AlarmRepositoryImpl(localDataSource = localDataSource) }

    companion object {

    }
}