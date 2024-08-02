package com.si.fanalytics.match_predictor.framework.data.model

data class ApplyBoosterRequestE(
    val opt_type:Int,
    val tourid: Int,
    val soccer_matchid:String,
    val tour_gamedayid:Int,
    val platformid:Int,
    val boosterid:Int,

)
