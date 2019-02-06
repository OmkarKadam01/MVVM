package com.mvvm.ui.landing.pojo

import com.google.gson.annotations.SerializedName

data class StandingsData(

	@field:SerializedName("last_updated")
	val lastUpdated: String? = null,

	@field:SerializedName("parent_series_id")
	val parentSeriesId: Int? = null,

	@field:SerializedName("groups")
	val groups: List<GroupsItem?>? = null,

	@field:SerializedName("series_id")
	val seriesId: Int? = null,

	@field:SerializedName("parent_series_global_id")
	val parentSeriesGlobalId: Int? = null
)