package com.maxor.turopizza.mvp.turo

import com.maxor.turopizza.data.TuroBusinessData
import com.maxor.turopizza.web.model.Businesses
import javax.inject.Singleton

interface TuroMvpContract {
    interface View {
        fun showBusinesses(businesses: List<TuroBusinessData>)
        fun showBusinessesFail()
    }
    interface Presenter {
        fun bindView(view: View)
        fun fetchBusinesses(term: String)
        fun cleanup()
    }

}