package com.si.fanalytics.predictor_core.business.domain.model.requests

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JoinLeagueRequest(
    val tourId: Int,
    val optType:Int,
    val gamedayId:Int,
    val leagueName:String,
    val leagueCode:Int,
    val leagueId:Int,
):Parcelable
