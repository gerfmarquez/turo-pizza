package com.maxor.turopizza.mvp

import android.os.Bundle
import com.maxor.turopizza.R
import com.maxor.turopizza.web.model.Businesses
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class TuroActivity : DaggerAppCompatActivity(), TuroMvpContract.View {

    @Inject
    lateinit var turoPresenter: TuroMvpContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        turoPresenter.fetchBusinesses("pizza",42.283730, -83.737003)

    }

    override fun showBusinesses(businesses: List<Businesses>) {
        TODO("Not yet implemented")
    }

    override fun showBusinessesFail() {
        TODO("Not yet implemented")
    }
}
