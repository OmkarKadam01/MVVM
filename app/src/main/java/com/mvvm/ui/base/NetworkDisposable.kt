package com.mvvm.ui.base

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class NetworkDisposable<T>(val viewModel: BaseViewModel):Observer<T> {


    override fun onComplete() {


    }

    override fun onSubscribe(d: Disposable) {


    }

    override fun onNext(t: T) {


    }

    override fun onError(e: Throwable) {


    }


}