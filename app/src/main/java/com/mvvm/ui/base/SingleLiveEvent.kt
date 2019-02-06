package com.mvvm.ui.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import android.support.annotation.Nullable
import android.util.Log
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>(){
    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }

        super.observe(owner, object :Observer<T>{
            override fun onChanged(@Nullable t: T?) {
            if (mPending.compareAndSet(true,false)){
                observer.onChanged(t)
            }
            }
        })
    }

    @MainThread
    override fun setValue(@Nullable value: T?) {
        mPending.set(true)
        super.setValue(value)
    }
    @MainThread
    fun call() {
        setValue(null)
    }
    companion object {

        private val TAG = "SingleLiveEvent"
    }
}