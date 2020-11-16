package com.maxor.turopizza.injection

import com.maxor.turopizza.TuroApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/** This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * Copyright 2020, Gerardo Marquez.
 */

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