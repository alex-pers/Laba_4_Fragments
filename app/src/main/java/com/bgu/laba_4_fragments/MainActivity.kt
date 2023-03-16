package com.bgu.laba_4_fragments

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), NavigationInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LIFE_CYCLE", "MainActivity 1 onCreate")
        openFragment1()
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

    override fun openFragment1() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment1 = Fragment1()

        transaction.add(R.id.fragment_container, fragment1, fragment1.javaClass.simpleName)
        transaction.commit()
    }

    override fun openFragment2() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment2 = Fragment2()

        transaction.replace(R.id.fragment_container, fragment2, fragment2.javaClass.simpleName)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}