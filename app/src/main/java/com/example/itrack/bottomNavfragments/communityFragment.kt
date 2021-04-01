package com.example.itrack.bottomNavfragments

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.itrack.R



class communityFragment : Fragment(R.layout.fragment_community) {
    lateinit var  imageslider:ImageSlider
    lateinit var  webview: WebView
    lateinit var  searchView: SearchView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageslider = view.findViewById(R.id.image_slider)

        var imgList = ArrayList<SlideModel>()
        imgList.add(SlideModel(R.drawable.image_1,ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.images_2,ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.image_3,ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.images_4,ScaleTypes.FIT))
        imageslider.setImageList(imgList,ScaleTypes.FIT)

        webview = view.findViewById(R.id.webview)
        webview.webViewClient = WebViewClient()
        searchView = view.findViewById<SearchView>(R.id.searchview)
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                webview.loadUrl("https://www.google.com/search?q="+searchView.query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })





    }


}




