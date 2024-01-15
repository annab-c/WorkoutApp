package com.example.workoutapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workoutapp.Workout
import com.example.workoutapp.createWorkouts

var workoutRepository = WorkoutRepository()

class WorkoutRepository {

    private val workouts : MutableLiveData<List<Workout>> = MutableLiveData(
        createWorkouts(50)
    )

    fun readAll(): LiveData<List<Workout>> {
        return workouts

    }

    fun addWorkout() {

        val currentList = workouts.value ?: emptyList()

        val newWorkoutList = currentList + createWorkouts(1)

        workouts.value = newWorkoutList
    }
}