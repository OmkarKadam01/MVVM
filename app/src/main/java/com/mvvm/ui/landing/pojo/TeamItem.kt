package com.mvvm.ui.landing.pojo

import com.google.gson.annotations.SerializedName
data class TeamItem(

	@field:SerializedName("points_conceded")
	val pointsConceded: String? = null,

	@field:SerializedName("position_status")
	val positionStatus: String? = null,

	@field:SerializedName("team_id")
	val teamId: Int? = null,

	@field:SerializedName("away_wins")
	val awayWins: String? = null,

	@field:SerializedName("prev_position")
	val prevPosition: String? = null,

	@field:SerializedName("points")
	val points: String? = null,

	@field:SerializedName("team_global_id")
	val teamGlobalId: Int? = null,

	@field:SerializedName("lost")
	val lost: String? = null,

	@field:SerializedName("match_result")
	val matchResult: MatchResult? = null,

	@field:SerializedName("draws")
	val draws: String? = null,

	@field:SerializedName("ga")
	val ga: String? = null,

	@field:SerializedName("away_points_conceded")
	val awayPointsConceded: String? = null,

	@field:SerializedName("points_scored")
	val pointsScored: String? = null,

	@field:SerializedName("gf")
	val gf: String? = null,

	@field:SerializedName("wins")
	val wins: String? = null,

	@field:SerializedName("tied")
	val tied: String? = null,

	@field:SerializedName("away_points_scored")
	val awayPointsScored: String? = null,

	@field:SerializedName("played")
	val played: String? = null,

	@field:SerializedName("team_name")
	val teamName: String? = null,

	@field:SerializedName("score_diff")
	val scoreDiff: String? = null,

	@field:SerializedName("home_wins")
	val homeWins: String? = null,

	@field:SerializedName("trump_matches_won")
	val trumpMatchesWon: String? = null,

	@field:SerializedName("team_short_name")
	val teamShortName: String? = null,

	@field:SerializedName("position")
	val position: String? = null,

	@field:SerializedName("noresult")
	val noresult: String? = null,

	@field:SerializedName("is_qualified")
	val isQualified: Boolean? = null
)