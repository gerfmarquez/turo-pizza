package com.maxor.turopizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.maxor.turopizza.web.TuroService
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var turoService: TuroService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread {
            turoService.searchBusinessNearby("pizza",42.283730, -83.737003)

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( { successData ->
                    Log.d("","")
                },
                {
                    Log.d("","")
                }
            )
        }.start()
    }
}
