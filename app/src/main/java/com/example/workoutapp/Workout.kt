package com.example.workoutapp

import java.io.Serializable
import java.lang.System.currentTimeMillis
import java.util.Calendar
import kotlin.random.Random

fun currentDate() = System.currentTimeMillis()

enum class WorkoutType {
    Running, Biking, Swimming, Judo, JiuJitsu, Bouldering, Stretching, Yoga
}

class Workout(
    var workoutType: WorkoutType,
    var workoutDate: Long = currentDate(),
    var workoutDuration: Int
) : Serializable

fun createWorkouts(workoutCount: Int): List<Workout> =
    (1..workoutCount).map {
        val workoutType = WorkoutType.entries.toTypedArray().random()
        val workoutDuration = Random.nextInt(30, 120)

        Workout(workoutType, workoutDate = currentDate(), workoutDuration)
    }