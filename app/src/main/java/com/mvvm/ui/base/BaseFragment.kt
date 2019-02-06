package com.mvvm.ui.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment <T: ViewDataBinding , V: BaseViewModel>: Fragment(){


    private var mActivity : BaseActivity<*,*>? = null
    private var mRootView: View? = null
    private var mViewDataBinding: T? = null
    private var mViewModel: V? = null

    abstract fun getBindingVariable(): Int

    abstract fun getViewModel(): V


    @LayoutRes
    abstract fun getLayoutId():Int
    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
        setHasOptionsMenu(false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is BaseActivity<*,*>){
            val activity= context as BaseActivity<*,*>?
            mActivity= activity
            setHasOptionsMenu(false)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        mViewDataBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        mRootView= mViewDataBinding?.root
        return mRootView
    }

    override fun onDetach() {
        super.onDetach()
        mActivity=null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding?.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding?.executePendingBindings()
    }
    fun getBaseActivity(): BaseActivity<*,*> ?{
        return mActivity
    }

    fun getViewDataBinding(): T? {
        return mViewDataBinding
    }

    fun hideKeyboard() {
        if (mActivity != null) {
            mActivity?.hideKeyboard()
        }
    }


    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}