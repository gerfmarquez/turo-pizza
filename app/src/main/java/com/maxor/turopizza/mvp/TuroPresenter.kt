package com.maxor.turopizza.mvp

import android.util.Log
import com.maxor.turopizza.web.TuroService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TuroPresenter @Inject constructor(val turoService: TuroService) : TuroMvpContract.Presenter {

    override fun bindView(view: TuroMvpContract.View) {
        TODO("Not yet implemented")
    }

    override fun fetchBusinesses(term: String, lat: Double, lon: Double) {
        turoService.searchBusinessNearby(term,lat,lon)

        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe( { successData ->
                    Log.d("","")
                },
            {
                    Log.d("","")
                }
        )

    }

    override fun cleanup() {
        TODO("Not yet implemented")
    }

}