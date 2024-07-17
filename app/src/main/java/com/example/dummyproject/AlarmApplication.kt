package com.example.dummyproject

import android.app.Application
import android.content.Context
import androidx.room.RoomDatabase
import com.example.dummyproject.dao.AlarmDao
import com.example.dummyproject.data.AlarmRepositoryImpl
import com.example.dummyproject.data.LocalDataSource
import com.example.dummyproject.database.AlarmDatabase

class AlarmApplication: Application() {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: AlarmApplication

        fun applicationContext() : Context {
            return instance.applicationContext
        }
    }

}