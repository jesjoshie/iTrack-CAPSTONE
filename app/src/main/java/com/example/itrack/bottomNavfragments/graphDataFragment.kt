package com.example.itrack.bottomNavfragments

import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.itrack.Home
import com.example.itrack.MainActivity
import com.example.itrack.R
import com.example.itrack.adapters.ListOfGraphSelection
import com.example.itrack.adapters.graphGridView
import com.google.android.material.bottomnavigation.BottomNavigationView


class graphDataFragment : Fragment(R.layout.fragment_graph_data){
    lateinit var selectionView: GridView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectionView = view.findViewById(R.id.dataGraphGridView)
        val adapater = graphGridView(requireActivity(), addDataGrid())
        selectionView.adapter = adapater

    }

    private fun addDataGrid(): ArrayList<ListOfGraphSelection> {
        var sList = ArrayList<ListOfGraphSelection>()
        sList.add(ListOfGraphSelection(R.drawable.graph_icon, "BBT and Custom Data"))
        sList.add(ListOfGraphSelection(R.drawable.mood_tracker, "Mood Tracker"))
        sList.add(ListOfGraphSelection(R.drawable.step_icon, "Pedometer"))
        return sList
    }
}




