package com.mvvm.repository

import com.mvvm.repository.local.prefs.PreferencesHelper
interface DataManagerContract:  PreferencesHelper {


    /**
     * interface acts a common gateway point to access data in a repository pattern
     * add constants , enums or other custom queries to data layer when required
     */
}