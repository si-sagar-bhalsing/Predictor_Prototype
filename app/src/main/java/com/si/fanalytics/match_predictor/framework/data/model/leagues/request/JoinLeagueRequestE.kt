package com.si.fanalytics.match_predictor.framework.data.model.leagues.request


data class JoinLeagueRequestE(
    val tourId: Int,
    val optType:Int,
    val gamedayId:Int,
    val leagueName:String,
    val leagueCode:Int,
    val leagueId:Int,
    val language:String
)
