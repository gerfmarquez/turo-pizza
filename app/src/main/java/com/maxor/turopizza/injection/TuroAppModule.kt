package com.maxor.turopizza.injection


import com.maxor.turopizza.mvp.turo.TuroActivity
import com.maxor.turopizza.mvp.turo.TuroFragment

import dagger.Module

import dagger.android.ContributesAndroidInjector

/** This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * Copyright 2020, Gerardo Marquez.
 */

@Module
abstract class TuroAppModule {

    @ContributesAndroidInjector
    abstract fun  bindMainActivity() : TuroActivity

    @ContributesAndroidInjector
    abstract fun bindTuroFragment() : TuroFragment

}