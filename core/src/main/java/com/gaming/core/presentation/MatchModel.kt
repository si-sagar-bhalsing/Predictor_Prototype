package com.gaming.core.presentation

data class Match(
    val matchId: Int,
    val homeTeam: String,
    val homeTeamFlag: Int,
    var predictedHomeScore: Int?,
    var predictedAwayScore: Int?,
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