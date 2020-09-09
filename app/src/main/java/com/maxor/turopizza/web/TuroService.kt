package com.maxor.turopizza.web

import com.maxor.turopizza.web.model.TuroBaseResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface TuroService {

    @GET("v3/businesses/search")
    fun fetch(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double) : Single<TuroBaseResponse>


    companion object  {
        val apiKey: String = "2ROaa2Rh9qu3WVTCms8FoVE4mSfHQHC7QJua95-kKT-PqzIlLSrs4tmHVdtdFw_66-JNfRiJmb\n" +
                "CByHTvFNy5dQq-tpfS4FrPpupIzKlgELR3br-r5trpeFhrCRgwWnYx"
        val baseUrl: String = "https://api.yelp.com/"
        fun create(): TuroService {

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(ParametersInterceptor())

            return  Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())

                .client(httpClient.build())
                .build().create(TuroService::class.java)
        }
    }
}