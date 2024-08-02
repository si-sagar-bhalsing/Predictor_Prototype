package com.si.fanalytics.match_predictor.business.domain.model.Requests

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApplyBoosterRequest (
    val tourId: Int,
    val optType:Int,
    val soccerMatchId:String,
    val tourGameDayId:Int,
    val boosterId:Int
    ):Parcelable