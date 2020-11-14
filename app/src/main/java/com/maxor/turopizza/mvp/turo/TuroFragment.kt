package com.maxor.turopizza.mvp.turo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.maxor.turopizza.R
import com.maxor.turopizza.data.TuroBusinessData
import com.maxor.turopizza.views.BusinessesAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_turo_search_fragment.view.*
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton


class TuroFragment  @Inject constructor(): DaggerFragment() {

    var businessesAdapter: BusinessesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val layout : RecyclerView = inflater.inflate(R.layout.view_turo_search_fragment,   container,  false) as RecyclerView

        businessesAdapter = BusinessesAdapter()

        layout.rv_turo_nearby_businesses.adapter = businessesAdapter

        return layout
    }

}