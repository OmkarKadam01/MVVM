package com.mvvm.ui.landing.pojo

import com.mvvm.repository.Models.Mapper

class Standings : Mapper<TeamItem,Standings>{

    lateinit var clubName: String
    lateinit var clubShortName: String
    lateinit var teamPos: String
    lateinit var clubGP: String
    lateinit var clubWin: String
    lateinit var clubDraw: String
    lateinit var clubLoss: String
    lateinit var clubGF: String
    lateinit var clubGA: String
    lateinit var clubGD: String
    lateinit var clubPts: String
    var teamId: Int = 0
    var isQualified: Boolean = false
    var jfcClub: Boolean = false
    var evenClub: Boolean = false

    override fun mapFrom(t: TeamItem): Standings {

        when (t.isQualified) {
            true -> clubName = t.teamName + " [Q]"
            false -> clubName = t.teamName ?: ""
        }

        clubShortName = t.teamShortName ?: ""
        teamPos = t.position ?: ""
        clubGP = t.played ?: ""
        clubWin = t.wins ?: ""
        clubDraw = t.draws ?: ""
        clubLoss = t.lost ?: ""
        clubGF = t.gf ?: ""
        clubGA = t.ga ?: ""
        clubGD = gdCalculation(t.gf, t.ga)
        clubPts = t.points ?: ""
        teamId = t.teamId ?: 0
        isQualified = t.isQualified ?: false
        return this
    }

    private fun gdCalculation(gf: String?, ga: String?): String {


        val difference = gf!!.toInt() - ga!!.toInt()

        return difference.toString() + ""

    }

    override fun toString(): String {
        return "Standings(clubName='$clubName', clubShortName='$clubShortName', teamPos='$teamPos', clubGP='$clubGP', clubWin='$clubWin', clubDraw='$clubDraw', clubLoss='$clubLoss', clubGF='$clubGF', clubGA='$clubGA', clubGD='$clubGD', clubPts='$clubPts', teamId=$teamId, isQualified=$isQualified, jfcClub=$jfcClub, evenClub=$evenClub)"
    }


}