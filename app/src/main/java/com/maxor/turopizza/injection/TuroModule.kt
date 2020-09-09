package com.maxor.turopizza.injection

import com.maxor.turopizza.web.TuroService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TuroModule {

    @Singleton
    @Provides
    fun provideWeatherService(): TuroService {
        return TuroService.create()
    }
}