package com.mvvm.ui.landing

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.LinearLayoutManager
import com.mvvm.di.qualifiers.LandingInfo
import com.mvvm.repository.DataManager
import com.mvvm.ui.ViewModelFactory
import com.mvvm.ui.landing.adapter.LandingAdapter
import com.mvvm.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
@Module
class LandingActivityModule{

    @Provides
    fun provideLandingViewModel(dataManager: DataManager,
                                schedulerProvider: SchedulerProvider): LandingViewModel {

        return LandingViewModel(dataManager, schedulerProvider)

    }


    @Provides
    fun landingViewModelProvider(landingViewModel: LandingViewModel): ViewModelProvider.Factory {
        return ViewModelFactory(landingViewModel)
    }
    @Provides
    fun provideFixturesAdapter()= LandingAdapter(ArrayList())


    @Provides
    fun provideLinearLayoutManager(activity: LandingActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }
    /*@Provides
    fun provideLandingFragments(): LandingFactoryImpl = LandingFactoryImpl()

    @Provides
    fun provideHomeFixturesAdapter() = HomeFixturesSwipingAdapter(ArrayList())


    @Provides
    fun provideLinearLayoutManager(fragment: LandingPage): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }

    @Provides
    fun providesSnapHelper() = PagerSnapHelper()


    @Provides
    fun  provideLandingPagerAdapter(landingPage:LandingPage)=LandingviewPagerAdapter(landingPage.childFragmentManager,ArrayList())
*/
}