package com.maxor.turopizza

import com.maxor.turopizza.injection.DaggerTuroComponent
import dagger.android.DaggerApplication

class TuroApp : DaggerApplication() {

    override fun applicationInjector() = DaggerTuroComponent.builder()
        .application(this)
        .build()
}