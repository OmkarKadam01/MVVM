package com.mvvm.ui.base.navigation

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.text.TextUtils
import com.mvvm.R
import com.mvvm.ui.base.BaseFragment
import com.mvvm.utils.Tracker
import java.lang.ref.WeakReference


abstract class BaseNavigator(val mFragmentManager:WeakReference<FragmentManager>,mActivity: WeakReference<Activity>
                             ,mTracker: Tracker,val mainContainer:Int ):Navigator{

    protected fun showFragmentWithAnimation(fragment: Fragment,fragmentTag: String,addToBackStack: Boolean){
        showFragmentWithTag(fragment,addToBackStack ,fragmentTag,true)
    }

    @SuppressLint("ResourceType")
    private fun showFragmentWithTag(fragment: Fragment, addToBackStack:Boolean,fragmentTag: String, withAnimation: Boolean) {
        if (mFragmentManager.get()!=null){
            if (isFragmentOnTop(fragmentTag)){
                if (fragment is BaseFragment<*, *>){


                }else {
                    val fragmentTransaction = mFragmentManager.get()!!.beginTransaction()
                    if (withAnimation){
                        fragmentTransaction.setCustomAnimations(R.anim.slide_right_in,
                            R.anim.slide_left_out,R.anim.slide_left_in,R.anim.slide_right_out)
                    }
                    fragmentTransaction.replace(mainContainer,fragment,fragmentTag)
                    if(addToBackStack){
                       fragmentTransaction.addToBackStack(fragmentTag)
                    }
                    fragmentTransaction.commitAllowingStateLoss()
                }



            }
        }

    }

    private fun findFragmentByTag(tag: String): Fragment? {
        var fragment: Fragment? = null
        if (mFragmentManager.get() != null) {
            fragment = mFragmentManager.get()!!.findFragmentByTag(tag)
        }
        return fragment
    }

    private fun isFragmentOnTop(fragmentTag: String): Boolean {
        val fragmentManager = mFragmentManager.get()
        var fragmentOnTop = false
        if (fragmentManager != null && !TextUtils.isEmpty(fragmentTag)) {
            val count = fragmentManager.backStackEntryCount
            fragmentOnTop = if (count > 0) {
                val tag = fragmentManager.getBackStackEntryAt(count - 1).name
                tag != null && tag == fragmentTag
            } else {
                val fragment = fragmentManager.findFragmentById(mainContainer)
                null != fragment && fragmentTag == fragment.tag
            }
        }
        return fragmentOnTop
    }

    protected fun getTopFragmentTag(): String? {
        var tag: String? = null
        if (mFragmentManager.get() != null) {
            val count = mFragmentManager.get()!!.backStackEntryCount
            if (count > 0) {
                val entry = mFragmentManager.get()!!.getBackStackEntryAt(count - 1)
                tag = entry.name
            }
        }
        return tag
    }

    protected fun findFragment(tag: String): Fragment? {
        var fragment: Fragment? = null
        if (mFragmentManager.get() != null) {
            fragment = mFragmentManager.get()!!.findFragmentByTag(tag)
        }
        return fragment
    }

    fun goBack() {
        if (mFragmentManager.get() != null) {
            mFragmentManager.get()!!.popBackStack()
        }
    }


    fun clearStackFromScreen(tag: String) {
        if (mFragmentManager.get() != null) {
            mFragmentManager.get()!!.popBackStack(tag, android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

}