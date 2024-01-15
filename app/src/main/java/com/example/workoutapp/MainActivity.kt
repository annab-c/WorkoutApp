package com.example.workoutapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.workoutapp.ui.theme.WorkoutAppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "onDestroy()")
    }
}