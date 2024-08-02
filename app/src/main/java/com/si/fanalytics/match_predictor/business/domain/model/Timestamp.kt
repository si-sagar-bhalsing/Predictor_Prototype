package com.si.fanalytics.match_predictor.business.domain.model

data class Timestamp(
    val CESTTime: String,
    val ISTTime: String,
    val UTCTime: String
)