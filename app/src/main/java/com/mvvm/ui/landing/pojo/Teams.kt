package com.mvvm.ui.landing.pojo

import com.google.gson.annotations.SerializedName

data class Teams(

	@field:SerializedName("team")
	val team: List<TeamItem?>? = null
)