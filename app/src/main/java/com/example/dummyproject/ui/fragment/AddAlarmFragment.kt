package com.example.dummyproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dummyproject.AlarmApplication
import com.example.dummyproject.R
import com.example.dummyproject.databinding.FragmentAddAlarmBinding
import com.example.dummyproject.model.AlarmModel
import com.example.dummyproject.model.UIEvent
import com.example.dummyproject.viewmodel.AddAlarmViewModel
import com.example.dummyproject.viewmodel.factory.AddAlarmViewModelFactory
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class AddAlarmFragment: Fragment(R.layout.fragment_add_alarm) {

    private val addAlarmViewModel by viewModels<AddAlarmViewModel> {
        AddAlarmViewModelFactory((requireActivity().application as AlarmApplication).alarmRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentAddAlarmBinding>(view)?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = addAlarmViewModel
            saveAlarm.setOnClickListener { addAlarmViewModel.addAlarm() }
            addEventObserver()
        }
    }

    private fun addEventObserver() {
        addAlarmViewModel.uiEvent.observe(viewLifecycleOwner) {
            when (it.getEventIfHandled()) {
                UIEvent.NavigateToHome -> findNavController().navigate(
                    AddAlarmFragmentDirections.actionAddAlarmFragmentToFirstFragment()
                )

                else -> {}
            }
        }
    }
}