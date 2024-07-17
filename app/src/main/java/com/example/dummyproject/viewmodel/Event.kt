package com.example.dummyproject.viewmodel

class Event<out T>(private val content: T) {
    private var hasHandled = false
    fun getEventIfHandled(): T? = if(hasHandled) {
        null
    } else {
        hasHandled = true
        content
    }
}