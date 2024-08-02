package com.si.fanalytics.match_predictor.business.domain.model.requests

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreateLeagueRequest (
    val tourId: Int,
    val optType:Int,
    val gamedayId:Int,
    val leagueName:String,
    val leagueCode:Int,
    val leagueId:Int,
):Parcelable