package com.si.fanalytics.match_predictor.business.domain.model

data class OptionLists(
    val assetType: String?,
    val cfAssetId: String?,
    val cfOptionId: Int?,
    val cfQuestionId: Int?,
    val isCorrect: Int?,
    val maxVal: Int?,
    val minVal: Int?,
    val optionDec: String?,
    val voteCount: Int?
)
