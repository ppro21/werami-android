package com.pprodev.werami.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private val sharedGreeting = MutableLiveData<String>()

    private var greetWord = "Welcome"
    fun sendGreeting() {
        sharedGreeting.value = "$greetWord, from SharedViewModel!!!"
        cycleGreeting()
    }

    fun getGreetings(): LiveData<String> {
        return sharedGreeting
    }

    private fun cycleGreeting() {
        viewModelScope.launch {
            repeat(3) {
                delay(800L)
                when (it + 1) {
                    1 -> greetWord = "Howdy Mate"
                    2 -> greetWord = "Good day"
                    3 -> greetWord = "Wassup"
                }
                sharedGreeting.value = "$greetWord, from SharedViewModel!!!"
            }
        }
    }

}