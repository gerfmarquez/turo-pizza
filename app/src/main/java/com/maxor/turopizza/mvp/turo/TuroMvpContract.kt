package com.maxor.turopizza.mvp.turo

import com.maxor.turopizza.data.TuroBusinessData
import com.maxor.turopizza.web.model.Businesses
import javax.inject.Singleton

/** This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * Copyright 2020, Gerardo Marquez.
 */

interface TuroMvpContract {

    interface Presenter {
        fun bindView(view: View)
        fun fetchBusinesses(term: String)
        fun cleanup()
    }

    interface View {
        fun showBusinesses(businesses: List<TuroBusinessData>)
        fun showBusinessesFail()
    }
}