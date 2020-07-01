package com.example.wongnaiassignmentapplication.livedata

data class Event<out T>(
    private val _content: T
) {
    private var _isHandle = false

    @Suppress("UNUSED")
    val isHandle: Boolean
        get() = _isHandle

    fun peekContent(): T = _content

    fun getContentIfNotHandled(): T? = kotlin.run {
        return@run if(_isHandle) {
            null
        }
        else {
            _isHandle = true
            _content
        }
    }

}