package com.example.dummyproject.viewmodel.viewstate

class ViewState<T> {
    var data: T? = null
    var loading: Boolean = false
    var error: ViewStateError? = null
}

data class ViewStateError(
    val code: Int?,
    val message: String?,
    val throwable: Throwable?
)