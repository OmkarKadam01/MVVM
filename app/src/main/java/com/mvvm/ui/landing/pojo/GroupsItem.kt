package com.mvvm.ui.landing.pojo

import com.google.gson.annotations.SerializedName

data class GroupsItem(

	@field:SerializedName("teams")
	val teams: Teams? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)