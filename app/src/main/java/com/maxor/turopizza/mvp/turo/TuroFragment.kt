package com.maxor.turopizza.mvp.turo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.maxor.turopizza.R
import com.maxor.turopizza.web.model.Businesses
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TuroFragment @Inject constructor() : DaggerFragment(), TuroMvpContract.View {


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val layout : LinearLayout = inflater.inflate(R.layout.view_turo_search_fragment,   container,  false) as LinearLayout

        return layout
    }


    override fun showBusinesses(businesses: List<Businesses>) {

    }

    override fun showBusinessesFail() {

    }
}