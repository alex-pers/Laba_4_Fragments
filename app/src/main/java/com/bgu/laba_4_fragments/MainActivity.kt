package com.bgu.laba_4_fragments

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bgu.laba_4_fragments.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LIFE_CYCLE", "MainActivity 1 onCreate")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFE_CYCLE", "MainActivity 1 onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFE_CYCLE", "MainActivity 1 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFE_CYCLE", "MainActivity 1 onDestroy")
    }

}