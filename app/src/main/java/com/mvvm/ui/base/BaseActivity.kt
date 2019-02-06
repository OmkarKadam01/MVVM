package com.mvvm.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import dagger.android.AndroidInjection
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

abstract class BaseActivity <T:ViewDataBinding,V : BaseViewModel>: AppCompatActivity(),BaseFragment.Callback{

    private lateinit var mViewDataBinding: T
    private lateinit var mViewModel: V

    abstract fun getBindingVariable() : Int

    abstract fun getViewModel() : V

    fun getViewDataBinding(): T = mViewDataBinding

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependancyInjuction()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {

        mViewDataBinding= DataBindingUtil.setContentView(this,getLayoutId())
        mViewModel = getViewModel()
        mViewDataBinding.setVariable(getBindingVariable(),getViewModel())
        mViewDataBinding.executePendingBindings()
    }

    fun performDependancyInjuction(){
         AndroidInjection.inject(this)
     }
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
}