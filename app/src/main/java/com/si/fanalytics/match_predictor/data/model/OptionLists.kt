package com.si.fanalytics.match_predictor.data.model

data class OptionLists(
    val asset_type: String,
    val cf_assetid: String,
    val cf_optionid: Int,
    val cf_questionid: Int,
    val is_correct: Int,
    val max_val: Int,
    val min_val: Int,
    val option_dec: String,
    val vote_count: Int
)