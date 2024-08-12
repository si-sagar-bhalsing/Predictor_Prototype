package com.si.fanalytics.predictor_core.framework.data.model.leagues.request

data class CreateLeagueRequestE (
    val optType:Int,
    val tourId: Int,
    val gamedayId:Int,
    val leagueName:String,
    val leagueCode:Int,
    val leagueId:Int,
    val language:String
    )