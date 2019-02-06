package com.mvvm.repository.remote

import com.mvvm.repository.remote.Utils.Gson
import com.mvvm.ui.landing.pojo.StandingsMainData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiHelper {

    /** list al api's used  in the app , differentiate with comments if list is small
     * if list becomes too large to maintain at some point of time
     *   -break the list into smaller intefaces representing each individual components
     *  - implement those interface in the Data repository abstraction
     */
    @GET
    @Gson
    fun getStandingsData(@Url standingsUrl: String): Observable<StandingsMainData>
}