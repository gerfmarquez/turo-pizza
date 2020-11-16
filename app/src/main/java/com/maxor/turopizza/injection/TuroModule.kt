package com.maxor.turopizza.injection

import com.maxor.turopizza.TuroApp
import com.maxor.turopizza.mvp.turo.TuroActivity
import com.maxor.turopizza.mvp.turo.TuroMvpContract
import com.maxor.turopizza.mvp.turo.TuroPresenter
import com.maxor.turopizza.mvp.turo.TuroFragment
import com.maxor.turopizza.web.TuroService
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Singleton

/** This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * Copyright 2020, Gerardo Marquez.
 */

@Module
abstract class TuroModule {

    @Binds
    abstract fun bindsTuroPresenter(turoPresenter: TuroPresenter)
            : TuroMvpContract.Presenter

    companion object {
        @Provides
        fun provideTuroService(turoapp: TuroApp): TuroService {
            return TuroService.create()
        }
    }


}