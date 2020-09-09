package com.maxor.turopizza.injection

import com.maxor.turopizza.TuroApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Component( modules = [AndroidInjectionModule::class, TuroModule::class, TuroAppModule::class ])
interface TuroComponent : AndroidInjector<TuroApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TuroApp): Builder

        fun build(): TuroComponent
    }

    override fun inject(app: TuroApp)

}