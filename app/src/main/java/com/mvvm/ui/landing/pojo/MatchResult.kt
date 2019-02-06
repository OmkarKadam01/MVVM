package com.mvvm.ui.landing.pojo

import com.google.gson.annotations.SerializedName

data class MatchResult(

	@field:SerializedName("match")
	val match: List<MatchItem?>? = null
)