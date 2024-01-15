package com.example.workoutapp.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.workoutapp.R
import com.example.workoutapp.createWorkouts

class ListFragment : androidx.fragment.app.Fragment(R.layout.fragment_list) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var refresher: SwipeRefreshLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvWorkouts)
        refresher = view.findViewById(R.id.swRefresher)
        setupList()
    }

    private fun setupList() {
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        // using viewModel
        val adapter = WorkoutsAdapter(ArrayList(createWorkouts(50)))

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            linearLayoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        refresher.setOnRefreshListener {
            adapter.updateWorkouts(ArrayList(adapter.workouts + createWorkouts(50)))
            refresher.isRefreshing = false
        }
    }
}