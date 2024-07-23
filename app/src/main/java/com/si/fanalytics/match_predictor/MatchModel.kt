package com.si.fanalytics.match_predictor

data class Match(
    val homeTeam: String,
    val homeTeamFlag: Int,
    val homeScore: Int,
    val awayTeam: String,
    val awayTeamFlag: Int,
    val awayScore: Int,
    val popularPredictions: List<Prediction>,
    val isLive: Boolean
)

data class Prediction(
    val score: String,
    val percentage: Int
)

data class MatchDay(
    val matchDay: String,
    val dateRange: String,
    val matches: List<Match>
)