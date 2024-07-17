package com.example.dummyproject.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dummyproject.R
import com.example.dummyproject.databinding.AlarmItemBinding
import com.example.dummyproject.model.AlarmModel

class AlarmListAdapter(
    private var alarmList: List<AlarmModel>
): RecyclerView.Adapter<AlarmListAdapter.AlarmListViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newAlarmList: List<AlarmModel>) {
        alarmList = newAlarmList
        notifyDataSetChanged()
    }

    class AlarmListViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.alarm_item, parent, false
        )
        return AlarmListViewHolder(view)
    }

    override fun getItemCount(): Int = alarmList.size

    override fun onBindViewHolder(holder: AlarmListViewHolder, position: Int) {
        val item = alarmList[position]
        DataBindingUtil.bind<AlarmItemBinding>(holder.itemView)?.apply {
            dateTime.text = item.dateTime.toString()
            description.text = item.title.ifEmpty { "No description provided" }
        }
    }

}