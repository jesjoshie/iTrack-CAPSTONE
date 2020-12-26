package com.example.itrack.bottomNavfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.example.itrack.R
import com.example.itrack.adapters.ListOfGraphSelection
import com.example.itrack.adapters.graphGridView


class graphDataFragment : Fragment(R.layout.fragment_graph_data) {
    lateinit var selectionView : GridView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectionView = view.findViewById(R.id.dataGraphGridView)
        val adapater = graphGridView(requireActivity(), addDataGrid())
        selectionView.adapter = adapater
    }

    private fun addDataGrid(): ArrayList<ListOfGraphSelection>{
        var sList = ArrayList<ListOfGraphSelection>()
        sList.add(ListOfGraphSelection(R.drawable.graph_icon, "BBT and Custom Data"))
        sList.add(ListOfGraphSelection(R.drawable.mood_tracker, "Mood Tracker"))
        sList.add(ListOfGraphSelection(R.drawable.step_icon, "Pedometer"))
        return sList
    }
}