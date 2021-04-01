package com.example.itrack.adapters

import android.content.Context
import android.media.Image
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.itrack.R

class graphGridView(var mcontext: Context, var selectionList: MutableList<ListOfGraphSelection>): BaseAdapter(){

    override fun getCount(): Int {
        return selectionList.size
    }

    override fun getItem(position: Int): Any {
        return selectionList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = View.inflate(mcontext, R.layout.row_graph_grid_view,null)
        val image = view.findViewById<ImageView>(R.id.imgGridView)
        val title = view.findViewById<TextView>(R.id.titleGridView)
        var imageIcon = selectionList.get(position)
        var titleText = imageIcon.title
        image.setImageResource(imageIcon.img)
        title.text = "$titleText"
        return view
    }
}