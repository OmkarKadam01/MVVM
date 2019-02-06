package com.mvvm.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.mvvm.repository.DataManager
import com.mvvm.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class  BaseViewModel(val dataManager: DataManager,val schedulerProvider: SchedulerProvider): ViewModel(){

    @Inject
    lateinit var command : SingleLiveEvent<ViewState>

    lateinit var mDataManger: DataManager

    var mIsLoading = ObservableBoolean(false)

    val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }
}