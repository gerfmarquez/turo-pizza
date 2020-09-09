package com.maxor.turopizza.injection

import com.maxor.turopizza.TuroApp
import com.maxor.turopizza.mvp.turo.TuroActivity
import com.maxor.turopizza.mvp.turo.TuroFragment
import com.maxor.turopizza.web.TuroService
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(includes = [TuroModule::class])
abstract class TuroAppModule {


    @ContributesAndroidInjector
    abstract fun  bindMainActivity() : TuroActivity

    @ContributesAndroidInjector
    abstract fun bindTuroFragment() : TuroFragment

    companion object {
        @Singleton
        @Provides
        fun provideTuroService(turoapp: TuroApp): TuroService {
            return TuroService.create()
        }

    }



}