package com.example.workoutapp.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.workoutapp.Workout
import com.example.workoutapp.WorkoutType

class DetailViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    fun read(): Workout {
        return savedStateHandle["workout"]!!
    }

    fun updateWorkout(workoutType: WorkoutType, workoutDate: Long, workoutDuration: Int) {
        val workout = read()

        workout.workoutType = workoutType
        workout.workoutDate = workoutDate
        workout.workoutDuration = workoutDuration
    }
}