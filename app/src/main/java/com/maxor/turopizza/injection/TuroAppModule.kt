package com.maxor.turopizza.injection

import com.maxor.turopizza.mvp.TuroActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [TuroModule::class])
interface TuroAppModule {

    @ContributesAndroidInjector
    fun  bindMainActivity() : TuroActivity

}