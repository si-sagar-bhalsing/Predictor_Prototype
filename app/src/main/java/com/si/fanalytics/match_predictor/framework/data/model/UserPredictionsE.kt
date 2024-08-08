package com.si.fanalytics.match_predictor.framework.data.model

import com.google.gson.annotations.SerializedName

data class UserPredictionsE(
    @SerializedName("POINTS") val points: Int?,
    @SerializedName("RANK") val rank: Int?,
    @SerializedName("MATCHID") val matchId: Int?,
    @SerializedName("GAMEDAYID") val gamedayId: Int?,
    @SerializedName("retType") val retType: Int?,
    @SerializedName("ANSWERS") val answers: List<ANSWERS>
)

data class ANSWERS(
    @SerializedName("MATCHID") var MATCHID: String?,
    @SerializedName("MHPOINTS") var MHPOINTS: String?,
    @SerializedName("OPTIONID") var OPTIONID: Int?,
    @SerializedName("ISBOOSTER") var ISBOOSTER: Int?,
    @SerializedName("QTNANSWER") var QTNANSWER: String?,
    @SerializedName("QUESTIONID") var QUESTIONID: Int?

)