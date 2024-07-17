package com.example.dummyproject.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dummyproject.domain.AlarmRepository
import com.example.dummyproject.viewmodel.AlarmListViewModel

class AlarmListViewModelFactory(
    private val repository: AlarmRepository
): ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return AlarmListViewModel(repository) as T
    }
}