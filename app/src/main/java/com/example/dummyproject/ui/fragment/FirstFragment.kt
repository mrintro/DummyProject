package com.example.dummyproject.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dummyproject.AlarmApplication
import com.example.dummyproject.R
import com.example.dummyproject.databinding.FragmentFirstBinding
import com.example.dummyproject.di.Injection
import com.example.dummyproject.ui.adapter.AlarmListAdapter
import com.example.dummyproject.viewmodel.AlarmListViewModel
import com.example.dummyproject.viewmodel.factory.AlarmListViewModelFactory

class FirstFragment: Fragment(R.layout.fragment_first) {

    private val alarmListViewModel by viewModels<AlarmListViewModel> {
        AlarmListViewModelFactory(Injection.alarmRepository)
    }
    private val alarmListAdapter by lazy {
        AlarmListAdapter(emptyList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentFirstBinding>(view)?.apply {
            lifecycleOwner = viewLifecycleOwner
            alarmListViewModel.getAlarmList()
            alarmList.adapter = alarmListAdapter
            addAlarm.setOnClickListener {
                findNavController().navigate(
                    FirstFragmentDirections.actionFirstFragmentToAddAlarmFragment()
                )
            }
            addObservers()
        }
    }

    private fun addObservers() {
        alarmListViewModel.alarmModelList.observe(viewLifecycleOwner) {
            Log.d("Alarm List", "${it}")
            alarmListAdapter.updateItems(it)
        }
    }

}