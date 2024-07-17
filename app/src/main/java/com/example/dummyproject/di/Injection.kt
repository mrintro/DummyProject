package com.example.dummyproject.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.dummyproject.AlarmApplication
import com.example.dummyproject.data.AlarmRepositoryImpl
import com.example.dummyproject.data.LocalDataSource
import com.example.dummyproject.database.AlarmDatabase
import com.example.dummyproject.domain.AlarmRepository

object Injection {

    private val applicationContext = AlarmApplication.applicationContext()

    private val database by lazy {
        AlarmDatabase.getInstance(applicationContext)
    }

    private val localDataSource by lazy { LocalDataSource(alarmDao = database.alarmDao()) }

    val alarmRepository by lazy { AlarmRepositoryImpl(localDataSource = localDataSource) }

}