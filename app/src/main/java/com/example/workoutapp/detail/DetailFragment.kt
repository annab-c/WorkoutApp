package com.example.workoutapp.detail

import android.os.Bundle
import android.view.View
import android.widget.Button
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workoutapp.R
import com.google.android.material.textfield.TextInputEditText
import java.util.Date

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val argumentsFromOverviewScreen: DetailFragmentArgs by navArgs()

    fun formatDate(timestamp: Long): String {
        var date = Date(timestamp)
        val format = SimpleDateFormat("dd -MM-yyyy", Locale.getDefault())
            return format.format(date)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workout = argumentsFromOverviewScreen.workout

        var etWorkoutType = view.findViewById<TextInputEditText>(R.id.etWorkoutType)
        etWorkoutType.setText(workout.workoutType.toString())

        var formattedDate = formatDate(workout.workoutDate)

        var etWorkoutDate = view.findViewById<TextInputEditText>(R.id.etWorkoutDate)
        etWorkoutDate.setText(formattedDate)

        var etWorkoutDuration = view.findViewById<TextInputEditText>(R.id.etWorkoutDuration)
        etWorkoutDuration.setText(workout.workoutDuration.toString())

        etWorkoutType.doAfterTextChanged { newType ->
        }

        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}