package com.example.workoutapp.detail

import android.os.Bundle
import android.view.View
import android.widget.Button
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workoutapp.R
import com.example.workoutapp.WorkoutType
import com.example.workoutapp.observer.LoggingObserver
import com.google.android.material.textfield.TextInputEditText
import java.text.ParseException
import java.util.Date

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val detailViewModel: DetailViewModel by viewModels()

    fun formatDate(timestamp: Long): String { var date = Date(timestamp)
        val format = SimpleDateFormat("dd -MM-yyyy", Locale.getDefault())
            return format.format(date)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(LoggingObserver())
        val workout = detailViewModel.read()
        val etWorkoutType = view.findViewById<TextInputEditText>(R.id.etWorkoutType)
        val etWorkoutDate = view.findViewById<TextInputEditText>(R.id.etWorkoutDate)
        val etWorkoutDuration = view.findViewById<TextInputEditText>(R.id.etWorkoutDuration)
        val button = view.findViewById<Button>(R.id.button)

        // Setting initial values
        etWorkoutType.setText(workout.workoutType.toString())
        etWorkoutDate.setText(formatDate(workout.workoutDate))
        etWorkoutDuration.setText(workout.workoutDuration.toString())

        button.setOnClickListener {

            val etWorkoutType = view.findViewById<TextInputEditText>(R.id.etWorkoutType)
            val updatedWorkoutType = etWorkoutType.text.toString()
            val etWorkoutDate = view.findViewById<TextInputEditText>(R.id.etWorkoutDate)
            val updatedWorkoutDate = etWorkoutDate.text.toString()
            val etWorkoutDuration = view.findViewById<TextInputEditText>(R.id.etWorkoutDuration)
            val updatedWorkoutDuration = etWorkoutDuration.text.toString()
            val workoutType = enumValueOf<WorkoutType>(updatedWorkoutType)
            val workoutDuration = updatedWorkoutDuration.toIntOrNull() ?: 0 // Default to 0 if conversion fails

            val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            var workoutDateLong: Long = 0

            try {
                val date = format.parse(updatedWorkoutDate)
                workoutDateLong = date?.time ?: 0 // Default to 0 if parsing fails
            } catch (e: ParseException) { }

                    detailViewModel.updateWorkout(
                        workoutType = workoutType,
                        workoutDate = workoutDateLong,
                        workoutDuration = workoutDuration
                    )

            findNavController().popBackStack()
        }
    }
}