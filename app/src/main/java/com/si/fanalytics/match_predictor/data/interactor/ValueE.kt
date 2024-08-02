package com.si.fanalytics.match_predictor.data.interactor

import com.google.gson.annotations.SerializedName
import com.si.fanalytics.match_predictor.data.model.Value
import javax.inject.Inject

data class ValueE(
    @SerializedName("MatchQuestions") val matchQuestions: List<MatchQuestionE>?,
   // @SerializedName("TeamAOutcome") val teamAOutcome: Any?,
    //@SerializedName("TeamBOutcome") val teamBOutcome: Any?,
    @SerializedName("awayTeamCountryCode") val awayTeamCountryCode: String?,
    @SerializedName("awayTeamId") val awayTeamId: Int?,
    //@SerializedName("awayTeamName") val awayTeamName: Any?,
    @SerializedName("awayTeamScore") val awayTeamScore: Int?,
    //@SerializedName("awayTeamShort") val awayTeamShort: Any?,
    //@SerializedName("correctPredId") val correctPredId: Any?,
    @SerializedName("countryCode") val countryCode: String?,
    //@SerializedName("dateTime") val dateTime: Any?,
    @SerializedName("deadline") val deadline: String?,
    @SerializedName("eot_flag") val eotFlag: Int?,
    @SerializedName("gameDate") val gameDate: String?,
    @SerializedName("gameIsCurrent") val gameIsCurrent: Int?,
    @SerializedName("gameIsLocked") val gameIsLocked: Int?,
    @SerializedName("gameNo") val gameNo: String?,
    @SerializedName("gameday") val gameday: String?,
    //@SerializedName("gamedayId") val gamedayId: Any?,
    @SerializedName("gdIsCurrent") val gdIsCurrent: Int?,
    @SerializedName("gdIsLocked") val gdIsLocked: Int?,
    @SerializedName("gd_TotalPlayers") val gdTotalPlayers: Int?,
    @SerializedName("homeTeamCountryCode") val homeTeamCountryCode: String?,
    @SerializedName("homeTeamId") val homeTeamId: Int?,
    //@SerializedName("homeTeamName") val homeTeamName: Any?,
    @SerializedName("homeTeamScore") val homeTeamScore: Int?,
    //@SerializedName("homeTeamShort") val homeTeamShort: Any?,
    @SerializedName("isCurrent") val isCurrent: Int?,
    @SerializedName("isFeedLive") val isFeedLive: String?,
    @SerializedName("isLive") val isLive: Int?,
    @SerializedName("isLock") val isLock: Int?,
    @SerializedName("matchDate") val matchDate: String?,
    @SerializedName("matchId") val matchId: String?,
    @SerializedName("matchName") val matchName: String?,
    @SerializedName("matchStatus") val matchStatus: Int?,
    @SerializedName("matchTime") val matchTime: String?,
    @SerializedName("matchday") val matchday: String?,
    @SerializedName("matchdayName") val matchdayName: String?,
    @SerializedName("maxSubstitutions_CF") val maxSubstitutionsCF: Int?,
    @SerializedName("maxTeamBalance") val maxTeamBalance: Double?,
    @SerializedName("maxTeamPlayers") val maxTeamPlayers: Int?,
    @SerializedName("mdIsCurrent") val mdIsCurrent: Int?,
    @SerializedName("mdIsLocked") val mdIsLocked: Int?,
    @SerializedName("md_TotalPlayers") val mdTotalPlayers: Int?,
    @SerializedName("mhIsCurrent") val mhIsCurrent: Int?,
    @SerializedName("mhIsLocked") val mhIsLocked: Int?,
    @SerializedName("notificationUpd") val notificationUpd: Int?,
    @SerializedName("phaseId") val phaseId: Int?,
    @SerializedName("pointsStatus") val pointsStatus: Int?,
    @SerializedName("predMatchStatus") val predMatchStatus: Int?,
    @SerializedName("round") val round: String?,
    @SerializedName("roundId") val roundId: Int?,
    //@SerializedName("stats") val stats: Any?,
    @SerializedName("substitutionsAllowed") val substitutionsAllowed: Int?,
    @SerializedName("teamA") val teamA: String?,
    @SerializedName("teamAName") val teamAName: String?,
    @SerializedName("teamAShortName") val teamAShortName: String?,
    @SerializedName("teamB") val teamB: String?,
    @SerializedName("teamBName") val teamBName: String?,
    @SerializedName("teamBShortName") val teamBShortName: String?,
    @SerializedName("teamGamedayId") val teamGamedayId: Int?,
    @SerializedName("tourGamedayId") val tourGamedayId: Int?,
    @SerializedName("tourId") val tourId: String?,
    @SerializedName("userPredCount") val userPredCount: Int?,
    @SerializedName("venueName") val venueName: String?
)

class ValueMapper @Inject constructor(private val matchQuestionMapper: MatchQuestionMapper) {
    fun toDomain(entity: ValueE): Value {
        return entity.run {
            Value(
                MatchQuestions = matchQuestions?.map { matchQuestionMapper.toDomain(it) },
                //TeamAOutcome = teamAOutcome,
                //TeamBOutcome = teamBOutcome,
                awayTeamCountryCode = awayTeamCountryCode,
                awayTeamId = awayTeamId,
                //awayTeamName = awayTeamName,
                awayTeamScore = awayTeamScore,
                //awayTeamShort = awayTeamShort,
                //correctPredId = correctPredId,
                countryCode = countryCode,
                //dateTime = dateTime,
                deadline = deadline,
                eot_flag = eotFlag,
                gameDate = gameDate,
                gameIsCurrent = gameIsCurrent,
                gameIsLocked = gameIsLocked,
                gameNo = gameNo,
                gameday = gameday,
                //gamedayId = gamedayId,
                gdIsCurrent = gdIsCurrent,
                gdIsLocked = gdIsLocked,
                gd_TotalPlayers = gdTotalPlayers,
                homeTeamCountryCode = homeTeamCountryCode,
                homeTeamId = homeTeamId,
                //homeTeamName = homeTeamName,
                homeTeamScore = homeTeamScore,
                //homeTeamShort = homeTeamShort,
                isCurrent = isCurrent,
                isFeedLive = isFeedLive,
                isLive = isLive,
                isLock = isLock,
                matchDate = matchDate,
                matchId = matchId,
                matchName = matchName,
                matchStatus = matchStatus,
                matchTime = matchTime,
                matchday = matchday,
                matchdayName = matchdayName,
                maxSubstitutions_CF = maxSubstitutionsCF,
                maxTeamBalance = maxTeamBalance,
                maxTeamPlayers = maxTeamPlayers,
                mdIsCurrent = mdIsCurrent,
                mdIsLocked = mdIsLocked,
                md_TotalPlayers = mdTotalPlayers,
                mhIsCurrent = mhIsCurrent,
                mhIsLocked = mhIsLocked,
                notificationUpd = notificationUpd,
                phaseId = phaseId,
                pointsStatus = pointsStatus,
                predMatchStatus = predMatchStatus,
                round = round,
                roundId = roundId,
                //stats = stats,
                substitutionsAllowed = substitutionsAllowed,
                teamA = teamA,
                teamAName = teamAName,
                teamAShortName = teamAShortName,
                teamB = teamB,
                teamBName = teamBName,
                teamBShortName = teamBShortName,
                teamGamedayId = teamGamedayId,
                tourGamedayId = tourGamedayId,
                tourId = tourId,
                userPredCount = userPredCount,
                venueName = venueName
            )
        }
    }
}

