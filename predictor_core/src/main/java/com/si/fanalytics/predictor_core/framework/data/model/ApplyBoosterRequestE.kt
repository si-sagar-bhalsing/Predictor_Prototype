package com.si.fanalytics.predictor_core.framework.data.model

data class ApplyBoosterRequestE(
    val opt_type:Int,
    val tourid: Int,
    val soccer_matchid:String,
    val tour_gamedayid:Int,
    val platformid:Int,
    val boosterid:Int,

)
