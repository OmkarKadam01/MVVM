package com.mvvm.ui.base

import android.support.annotation.StringRes


/** add all commands the activity can filter
 * from and do the appropriate action based on
 * configuration provided by viewstate class
 *
 **/

sealed class EventController {

    data class NoNetworkError(@StringRes val messageId: Int) : EventController()
    data class OtherNetworkErrors(@StringRes val messageId: Int) : EventController()
    data class LoadingState(val state: Boolean) : EventController()
    data class DisplayMessages(val message: String) : EventController()

}
