package com.example.workoutapp.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.workoutapp.Workout
import com.example.workoutapp.currentDate
import com.example.workoutapp.repository.workoutRepository

class ListViewModel() : ViewModel() {

    private val _counter = MutableLiveData(5)

    val counter: LiveData<Int> = _counter

    private val _searchTerm = MutableLiveData("")

    fun refreshTriggered() {
        _counter.value = 1 + (_counter.value ?: 0)
    }

    fun readAll(): LiveData<List<Workout>> {
        // Call the readAll function from the global repository in the ListViewModel
        return workoutRepository.readAll()
    }

    fun readAllFilteredByCount() = _counter.map { count ->
        val workouts = workoutRepository.readAll().value ?: emptyList()
        workouts.slice(0..count)
    }

    fun readAllFilteredByToday() = _searchTerm.map { searchTerm ->
        val workouts = workoutRepository.readAll().value ?: emptyList()
        workouts.filter { workout ->
            workout.workoutDate == currentDate() }
    }

    fun addWorkout() {
        workoutRepository.addWorkout()
    }

    fun onSearchTermEntered(searchTerm: String) {
        _searchTerm.value = searchTerm
    }

}
