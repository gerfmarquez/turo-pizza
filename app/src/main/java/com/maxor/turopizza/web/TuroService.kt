package com.maxor.turopizza.web

import com.maxor.turopizza.web.model.TuroBaseResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface TuroService {

    @GET("v3/businesses/search")
    fun searchBusinessNearby(
        @Query("term") term: String,
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double) : Single<TuroBaseResponse>


    companion object  {
        val apiKey: String = "2ROaa2Rh9qu3WVTCms8FoVE4mSfHQHC7QJua95-kKT-PqzIlLSrs4tmHVdtdFw_66-JNfRiJmb" +
                "CByHTvFNy5dQq-tpfS4FrPpupIzKlgELR3br-r5trpeFhrCRgwWnYx"
        val baseUrl: String = "https://api.yelp.com/"
        fun create(): TuroService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(ParametersInterceptor())
            httpClient.addInterceptor(interceptor)

            return  Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())

                .client(httpClient.build())
                .build().create(TuroService::class.java)
        }
    }
}