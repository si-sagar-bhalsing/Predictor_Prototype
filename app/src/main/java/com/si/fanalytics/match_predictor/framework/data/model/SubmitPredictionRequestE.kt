package com.si.fanalytics.match_predictor.framework.data.model

data class SubmitPredictionRequestE(

    val optType: Int,
    val tourId: Int,
    val soccerMatchId: String,
    val tourGameDayId: Int,
    val questionId: Int,
    val optionId: Int,
    val betCoin: Int,
    val platformId: Int,
    val boosterId: Int,
    val arrTeamId: List<String>

)