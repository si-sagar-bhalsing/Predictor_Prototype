package com.si.fanalytics.match_predictor.data.model

data class MatchQuestion(
    val CoinMult: Int,
    val CoinMultiplier: Any,
    val InningNo: Int,
    val IsLiveQuestion: Int,
    val LastQstn: Int,
    val LstQstnList: Any,
    val MatchId: String,
    val OptionJson: Any,
    val OptionLists: List<OptionLists>,
    val Options: Any,
    val PublishedDate: String,
    val QuestionCode: String,
    val QuestionDesc: String,
    val QuestionId: Int,
    val QuestionNo: Int,
    val QuestionNumber: Int,
    val QuestionOccurrence: String,
    val QuestionPoints: String,
    val QuestionTime: String,
    val QuestionType: String,
    val Status: Int,
    val TeamAId: Any,
    val TeamAName: Any,
    val TeamAScore: Any,
    val TeamBId: Any,
    val TeamBName: Any,
    val TeamBScore: Any
)