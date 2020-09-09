package com.maxor.turopizza.mvp.turo

import android.util.Log
import com.maxor.turopizza.mvp.location.LocationProvider
import com.maxor.turopizza.mvp.turo.TuroMvpContract
import com.maxor.turopizza.web.TuroService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TuroPresenter @Inject constructor(val turoService: TuroService, val locationProvider: LocationProvider) : TuroMvpContract.Presenter {

    private val disposables : MutableList<Disposable> = mutableListOf()

    private var turoView: TuroMvpContract.View? = null

    override fun bindView(view: TuroMvpContract.View) {
        turoView = view
    }

    override fun fetchBusinesses(term: String) {

        val locationDisdposable = locationProvider.getLocation().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {response ->
                val turoDisposable = turoService.searchBusinessNearby(term, response.lat,response.lon)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe( { successData ->
                            turoView?.showBusinesses(successData.businesses)
                        },
                        {
                            turoView?.showBusinessesFail()
                        }
                    )
                disposables.add(turoDisposable)
            }, {
                turoView?.showBusinessesFail()
            })

        disposables.add(locationDisdposable)

    }

    override fun cleanup() {
        for(disposable in disposables) {
            if (!disposable.isDisposed) {
                disposable.dispose()
            }
        }
    }

}