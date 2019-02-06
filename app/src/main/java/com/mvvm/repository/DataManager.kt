package com.mvvm.repository

import com.mvvm.repository.local.prefs.PreferencesHelper
import com.mvvm.repository.remote.ApiHelper
import com.mvvm.ui.landing.pojo.Standings
import com.mvvm.ui.landing.pojo.StandingsMainData
import com.mvvm.utils.rx.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

class DataManager @Inject constructor(private val apiHelper: ApiHelper,
                                      private val schedulerProvider: SchedulerProvider,
                                      private val sharedPreferences: PreferencesHelper): DataManagerContract
{
    fun getStandingsData(): Observable<List<Standings>> {


        val standingsUrl = "https://www.fcjamshedpur.com/sifeeds/football/live/india_sl/json/115_standings.json"
        return apiHelper.getStandingsData(standingsUrl).observeOn(schedulerProvider.io())
            .subscribeOn(schedulerProvider.io())
            .flatMapIterable { return@flatMapIterable it.standings?.groups?.get(0)?.teams?.team }
            .map { Standings().mapFrom(it) }
            .toList()
            .toObservable()
    }
}
