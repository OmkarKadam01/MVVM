package com.mvvm.ui.landing

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.BindingAdapter
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.mvvm.BR
import com.mvvm.R
import com.mvvm.databinding.ActivityLandingBinding
import com.mvvm.ui.ViewModelFactory
import com.mvvm.ui.base.BaseActivity
import com.mvvm.ui.landing.adapter.LandingAdapter
import com.mvvm.ui.landing.pojo.Standings
import javax.inject.Inject

@BindingAdapter("bind:adapter")
fun observeStandingList(recyclerView: RecyclerView, standingList: List<Standings>) {
    val adapter = recyclerView.adapter as? LandingAdapter
    adapter?.clearAllItems()
    adapter?.addAllItems(standingList)
}
class LandingActivity: BaseActivity<ActivityLandingBinding, LandingViewModel>() {
    @Inject
    lateinit var viewModelFactory:  ViewModelProvider.Factory

    lateinit var landingViewModel: LandingViewModel
    var mActivityLandingBinding: ActivityLandingBinding? = null
    @Inject
    lateinit var standingsAdapter: LandingAdapter
    @Inject
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLandingBinding = getViewDataBinding()
        landingViewModel.fetchStandingsListingData()
        setUpStandingsList()
        landingViewModel.standingsLiveData.observe(this, Observer { landingViewModel.updateStandingsList(it) })
    }
    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): LandingViewModel {
        landingViewModel = ViewModelProviders.of(this, viewModelFactory).get(LandingViewModel::class.java)
        return landingViewModel  as LandingViewModel  }

    override fun getLayoutId(): Int = R.layout.activity_landing

    private fun setUpStandingsList() {

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mActivityLandingBinding?.standingsRecyclerView?.itemAnimator = DefaultItemAnimator()
        mActivityLandingBinding?.standingsRecyclerView?.adapter = standingsAdapter


    }
}