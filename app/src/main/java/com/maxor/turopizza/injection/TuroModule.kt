package com.maxor.turopizza.injection

import com.maxor.turopizza.mvp.turo.TuroMvpContract
import com.maxor.turopizza.mvp.turo.TuroPresenter
import com.maxor.turopizza.mvp.turo.TuroFragment
import dagger.Binds
import dagger.Module

@Module
abstract class TuroModule {

    @Binds
    abstract fun bindsTuroPresenter(turoPresenter: TuroPresenter)
            : TuroMvpContract.Presenter

    @Binds
    abstract fun bindsTuroView(turoFragment: TuroFragment)
            : TuroMvpContract.View


}