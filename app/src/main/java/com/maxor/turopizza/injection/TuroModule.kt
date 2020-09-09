package com.maxor.turopizza.injection

import com.maxor.turopizza.mvp.turo.TuroMvpContract
import com.maxor.turopizza.mvp.turo.TuroPresenter
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
        fun provideTuroService(): TuroService {
            return TuroService.create()
        }
    }

}