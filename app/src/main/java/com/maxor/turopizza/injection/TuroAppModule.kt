package com.maxor.turopizza.injection

import com.maxor.turopizza.MainActivity
import com.maxor.turopizza.web.TuroService
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(includes = [TuroModule::class])
interface TuroAppModule {

    @ContributesAndroidInjector
    fun  bindMainActivity() : MainActivity

}