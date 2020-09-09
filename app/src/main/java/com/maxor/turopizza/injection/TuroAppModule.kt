package com.maxor.turopizza.injection

import com.maxor.turopizza.TuroApp
import com.maxor.turopizza.mvp.turo.TuroActivity
import com.maxor.turopizza.mvp.turo.TuroFragment
import com.maxor.turopizza.web.TuroService
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Scope
import javax.inject.Singleton

@Module
abstract class TuroAppModule {

    @ContributesAndroidInjector
    abstract fun  bindMainActivity() : TuroActivity

    @ContributesAndroidInjector
    abstract fun bindTuroFragment() : TuroFragment





}