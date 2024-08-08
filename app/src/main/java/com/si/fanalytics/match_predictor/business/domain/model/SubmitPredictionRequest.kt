package com.si.fanalytics.match_predictor.business.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SubmitPredictionRequest(
    val tourId: Int,
    val soccerMatchId: String,
    val tourGameDayId: Int,
    val questionId: Int,
    val optionId: Int,
    val betCoin: Int,
    val boosterId: Int,
    val arrTeamId: List<String>
):Parcelable
