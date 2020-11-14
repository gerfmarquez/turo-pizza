package com.maxor.turopizza.mvp.turo

import com.maxor.turopizza.RxImmediateSchedulerRule
import com.maxor.turopizza.data.TuroBusinessData
import com.maxor.turopizza.mvp.location.LocationData
import com.maxor.turopizza.mvp.location.LocationProvider
import com.maxor.turopizza.web.TuroService
import com.maxor.turopizza.web.model.Businesses
import com.maxor.turopizza.web.model.TuroBaseResponse
import io.reactivex.Single
import org.junit.Test

import org.junit.ClassRule
import org.junit.Rule
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TuroPresenterTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Mock
    lateinit var turoService: TuroService
    @Mock
    lateinit var locationProvider: LocationProvider
    @Mock
    lateinit var turoView : TuroMvpContract.View

    @InjectMocks
    lateinit var turoPresenter: TuroPresenter

    @Test
    fun testTuroPresenterFetchBusinesses() {

        val locationDataResponse = LocationData(1234,1.1,2.2)
        val turoServiceResponse = TuroBaseResponse()

        val businessData =  TuroBusinessData(
            4.5,"qwer1234","Restaurant",
            "http://png.png/png.png",23.34)
        turoServiceResponse.businesses.add(
                Businesses( rating = businessData.rating,
                            name = businessData.name,
                            id = businessData.id,
                            image_url = businessData.image_url,
                            distance = businessData.distance ))

        Mockito.`when`(locationProvider.getLocation()).thenReturn(Single.just(locationDataResponse))

        Mockito.`when`(turoService.searchBusinessNearby(Mockito.anyString(),
            Mockito.anyDouble(),Mockito.anyDouble())).thenReturn(Single.just(turoServiceResponse) )

        turoPresenter.bindView(turoView)

        turoPresenter.fetchBusinesses("dummy")

        Mockito.verify(turoView).showBusinesses(listOf(businessData))
    }
}
