package com.example.workoutapp

import java.io.Serializable
import java.lang.System.currentTimeMillis
import java.util.Calendar
import kotlin.random.Random

val currentDate =  currentTimeMillis()

enum class WorkoutType {
    Running, Biking, Swimming, Judo, JiuJitsu, Bouldering, Stretching, Yoga
}

class Workout(var workoutType: WorkoutType,
              var workoutDate: Long = currentDate(),
              var workoutDuration: Int, // Duration in minutes
              var runningDistance: Double? = null) : Serializable {

    companion object {
        fun currentDate(): Long = Calendar.getInstance().timeInMillis
    }
}

fun createWorkouts(workoutCount: Int): List<Workout> =
    (1..workoutCount).map { index ->
        val workoutType = WorkoutType.values().random()
        val workoutDuration = Random.nextInt(30, 120)

        val runningDistance = if (workoutType == WorkoutType.Running) {
            Random.nextDouble(5.0, 20.0)
        } else {
            null
        }

        Workout(
            workoutType = workoutType,
            workoutDuration = workoutDuration,
            runningDistance = runningDistance
        )
    }