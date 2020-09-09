package com.maxor.turopizza.mvp.turo

import com.maxor.turopizza.web.model.Businesses

interface TuroMvpContract {
    interface View {
        fun showBusinesses(businesses: List<Businesses>)
        fun showBusinessesFail()
    }
    interface Presenter {
        fun bindView(view: View)
        fun fetchBusinesses(term: String)
        fun cleanup()
    }

}