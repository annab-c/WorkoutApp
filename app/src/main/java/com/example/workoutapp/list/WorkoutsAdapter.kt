package com.example.workoutapp.list
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.R
import com.example.workoutapp.Workout
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WorkoutViewHolder(val listItemWorkoutRootView: View): RecyclerView.ViewHolder(listItemWorkoutRootView) {
    val workoutTypeTextView: TextView = listItemWorkoutRootView.findViewById(R.id.tvListItemWorkoutType)
    val workoutDateTextView: TextView = listItemWorkoutRootView.findViewById(R.id.tvListItemWorkoutDate)
    val workoutDurationTextView: TextView = listItemWorkoutRootView.findViewById(R.id.tvListItemWorkoutDuration)
}

class WorkoutsAdapter(var workouts: ArrayList<Workout>): RecyclerView.Adapter<WorkoutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemWorkoutRootView =
            layoutInflater.inflate(R.layout.list_item_workout, parent, false)
        return WorkoutViewHolder(listItemWorkoutRootView)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val workout = workouts[position]
        holder.workoutTypeTextView.text = workout.workoutType.toString()

        // Format the date from Long to a readable date format
        val date = Date(workout.workoutDate)
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        holder.workoutDateTextView.text = dateFormat.format(date)

        // Set duration
        holder.workoutDurationTextView.text = "${workout.workoutDuration} minutes"

        holder.listItemWorkoutRootView.setOnClickListener{
            val navHostFragment = holder.listItemWorkoutRootView.findNavController()
            navHostFragment.navigate(ListFragmentDirections.actionOverviewFragmentToDetailFragment(workout))
        }
    }

    override fun getItemCount(): Int {
        return workouts.size
    }

    fun updateWorkouts(workouts: ArrayList<Workout>) {
        this.workouts = workouts
        notifyDataSetChanged() // calls the recyclerview and refreshes it
    }
}