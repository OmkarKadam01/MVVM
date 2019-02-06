package com.mvvm.ui.landing

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList
import android.util.Log
import com.mvvm.repository.DataManager
import com.mvvm.ui.base.BaseViewModel
import com.mvvm.ui.landing.pojo.Standings
import com.mvvm.utils.rx.SchedulerProvider
import io.reactivex.Observable
import timber.log.Timber

class LandingViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
                      : BaseViewModel(dataManager,schedulerProvider),LifecycleObserver{
    val standingsLiveData: MutableLiveData<List<Standings?>> by lazy { MutableLiveData<List<Standings?>>() }

     val titleMenu: ObservableField<String> = ObservableField("sa")
    val standingsArrayList: ObservableList<Standings> = ObservableArrayList<Standings>()

    fun updateStandingsList(listOfAllMatches: List<Standings?>?) {

        listOfAllMatches?.let {
            standingsArrayList.clear()
            standingsArrayList.addAll(it)
        }

    }
    fun fetchStandingsListingData() {
        compositeDisposable.add(dataManager.getStandingsData().subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                standingsLiveData.value = it
                titleMenu.set(it.toString())
                Log.e("Android",it.toString())
            }) {
               // handleError(it)
                Timber.e(it)
            })

    }

}