package com.example.workoutapp.list

import androidx.lifecycle.ViewModel
import com.example.workoutapp.Workout
import com.example.workoutapp.createWorkouts

class ListViewModel : ViewModel() {

    private val workouts = createWorkouts(50)

    // add a readAll function
    fun readAll(): List<Workout> {
        return workouts
    }
}
