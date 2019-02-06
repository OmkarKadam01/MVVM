package com.mvvm.ui.landing.pojo

import com.google.gson.annotations.SerializedName

data class StandingsMainData(

	@field:SerializedName("standings")
	val standings: StandingsData? = null
)