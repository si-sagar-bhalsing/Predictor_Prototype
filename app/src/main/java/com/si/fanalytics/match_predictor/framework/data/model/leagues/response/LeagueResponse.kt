package com.si.fanalytics.match_predictor.framework.data.model.leagues.response

import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @SerializedName("LeagueId") val leagueId:String?,
    @SerializedName("ShowCelebrity") val showCelebrity:Int?,
    @SerializedName("LeagueName") val leagueName:String?,
    @SerializedName("LeagueCode") val leagueCode:String?,
    @SerializedName("ShareLoad") val shareLoad:String?
)
