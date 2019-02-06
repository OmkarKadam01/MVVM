package com.mvvm.ui.landing.pojo

import com.google.gson.annotations.SerializedName

data class MatchItem(

	@field:SerializedName("result")
	val result: String? = null,

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("teama_score")
	val teamaScore: Int? = null,

	@field:SerializedName("teamb_score")
	val teambScore: Int? = null,

	@field:SerializedName("post_match_position")
	val postMatchPosition: String? = null,

	@field:SerializedName("teamb_id")
	val teambId: Int? = null,

	@field:SerializedName("teama_id")
	val teamaId: Int? = null,

	@field:SerializedName("teama_short_name")
	val teamaShortName: String? = null,

	@field:SerializedName("teamb_short_name")
	val teambShortName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("prev_position")
	val prevPosition: String? = null
)