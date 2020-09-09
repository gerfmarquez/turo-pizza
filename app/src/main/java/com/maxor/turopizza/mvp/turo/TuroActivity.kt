package com.maxor.turopizza.mvp.turo

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.maxor.turopizza.R
import com.maxor.turopizza.data.TuroBusinessData
import com.maxor.turopizza.web.model.Businesses
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Singleton

class TuroActivity : DaggerAppCompatActivity(), TuroMvpContract.View{

    @Inject
    lateinit var turoPresenter: TuroMvpContract.Presenter


    override fun showBusinesses(businesses: List<TuroBusinessData>) {
        pg_loading.visibility = View.GONE

        (fragment_turo_businesses_results as TuroFragment).businessesAdapter?.submitList(businesses)

    }

    override fun showBusinessesFail() {
        pg_loading.visibility = View.GONE

        createAlertDialog("Please try again later")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        turoPresenter.bindView(this)

    }

    override fun onStop() {
        super.onStop()
        turoPresenter.cleanup()
    }

    fun searchTermBusinessesNearby(view : View) {
        checkPermissionsGranted()
    }

    fun createAlertDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setOnCancelListener {
                finish()
            }.create().show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 5)
            for((index,permission) in permissions.withIndex())
                if(grantResults[index] == PackageManager.PERMISSION_GRANTED)
                    when(permission) {
                        Manifest.permission.ACCESS_FINE_LOCATION -> {
                            turoPresenter.fetchBusinesses(et_search.text.toString())
                            pg_loading.visibility = VISIBLE
                        }

                    }
                else
                    createAlertDialog("Permission needs to be accepted for App to work properly")
    }
    fun checkPermissionsGranted()  {
        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),5)
    }

}
