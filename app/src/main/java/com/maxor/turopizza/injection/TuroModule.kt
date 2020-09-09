package com.maxor.turopizza.injection

import com.maxor.turopizza.mvp.TuroMvpContract
import com.maxor.turopizza.mvp.TuroPresenter
import com.maxor.turopizza.web.TuroService
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class TuroModule {

    @Binds
    abstract fun bindsTuroPresenter(gamesPresenter: TuroPresenter)
            : TuroMvpContract.Presenter

    companion object {
        @Singleton
        @Provides
        fun provideWeatherService(): TuroService {
            return TuroService.create()
        }
    }

}