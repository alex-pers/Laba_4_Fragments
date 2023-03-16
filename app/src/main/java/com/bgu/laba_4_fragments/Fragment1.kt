package com.bgu.laba_4_fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {

    override fun onAttach(activity: Context) {
        super.onAttach(activity)
        Log.d("LIFE_CYCLE", "Fragment 1 onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFE_CYCLE", "Fragment 1 onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("LIFE_CYCLE", "Fragment 1 onCreateView")
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_next).setOnClickListener {
            (activity as? NavigationInterface)?.openFragment2()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFE_CYCLE", "Fragment 1 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFE_CYCLE", "Fragment 1 onPause")
    }

    override fun onDetach() {
        Log.d("LIFE_CYCLE", "Fragment 1 onDetach")
        super.onDetach()
    }
}