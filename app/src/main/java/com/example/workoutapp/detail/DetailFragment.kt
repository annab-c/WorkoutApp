package com.example.workoutapp.detail

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workoutapp.R
import com.google.android.material.textfield.TextInputEditText

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val argumentsFromOverviewScreen: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workout = argumentsFromOverviewScreen.workout

        val etWorkoutType = view.findViewById<TextInputEditText>(R.id.etWorkoutType)
        etWorkoutType.setText(workout.workoutType.toString())

        val etWorkoutDate: TextInputEditText =
            view.findViewById(R.id.etWorkoutDate)
        etWorkoutDate.setText(workout.workoutDate.toString())

        val etWorkoutDuration = view.findViewById<TextInputEditText>(R.id.etWorkoutDuration)
        etWorkoutDuration.setText(workout.workoutDuration.toString())

        etWorkoutType.doAfterTextChanged { newType ->
        }

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}