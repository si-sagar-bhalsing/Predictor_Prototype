package com.si.fanalytics.match_predictor.business.domain.model

data class FeedTime(
    val CESTTime: String,
    val ISTTime: String,
    val UTCTime: String
)