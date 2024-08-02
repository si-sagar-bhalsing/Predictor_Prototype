package com.si.fanalytics.match_predictor.business.domain.model.requests

data class JoinLeagueRequest(
    val optType:Int,
    val gamedayId:Int,
    val leagueName:String,
    val leagueCode:Int,
    val leagueId:Int,
)
