package com.si.fanalytics.match_predictor.data.interactor

import com.google.gson.annotations.SerializedName
import com.si.fanalytics.match_predictor.data.model.MatchQuestion
import javax.inject.Inject

data class MatchQuestionE(
    @SerializedName("CoinMult") val coinMult: Int?,
    //@SerializedName("CoinMultiplier") val coinMultiplier: Any?,
    @SerializedName("InningNo") val inningNo: Int?,
    @SerializedName("IsLiveQuestion") val isLiveQuestion: Int?,
    @SerializedName("LastQstn") val lastQstn: Int?,
    //@SerializedName("LstQstnList") val lstQstnList: Any?,
    @SerializedName("MatchId") val matchId: String?,
    //@SerializedName("OptionJson") val optionJson: Any?,
    @SerializedName("OptionLists") val optionLists: List<OptionListsE>?,
    //@SerializedName("Options") val options: Any?,
    @SerializedName("PublishedDate") val publishedDate: String?,
    @SerializedName("QuestionCode") val questionCode: String?,
    @SerializedName("QuestionDesc") val questionDesc: String?,
    @SerializedName("QuestionId") val questionId: Int?,
    @SerializedName("QuestionNo") val questionNo: Int?,
    @SerializedName("QuestionNumber") val questionNumber: Int?,
    @SerializedName("QuestionOccurrence") val questionOccurrence: String?,
    @SerializedName("QuestionPoints") val questionPoints: String?,
    @SerializedName("QuestionTime") val questionTime: String?,
    @SerializedName("QuestionType") val questionType: String?,
    @SerializedName("Status") val status: Int?,
    //@SerializedName("TeamAId") val teamAId: Any?,
    //@SerializedName("TeamAName") val teamAName: Any?,
    //@SerializedName("TeamAScore") val teamAScore: Any?,
    //@SerializedName("TeamBId") val teamBId: Any?,
    //@SerializedName("TeamBName") val teamBName: Any?,
    //@SerializedName("TeamBScore") val teamBScore: Any?
)

class MatchQuestionMapper @Inject constructor(private val optionListsMapper: OptionListsMapper) {
    fun toDomain(entity: MatchQuestionE): MatchQuestion {
        return entity.run {
            MatchQuestion(
                coinMult = coinMult,
                //coinMultiplier = coinMultiplier,
                inningNo = inningNo,
                isLiveQuestion = isLiveQuestion,
                lastQstn = lastQstn,
                //lstQstnList = lstQstnList,
                matchId = matchId,
                //optionJson = optionJson,
                optionLists = optionLists?.map { optionListsMapper.toDomain(it) },
                //options = options,
                publishedDate = publishedDate,
                questionCode = questionCode,
                questionDesc = questionDesc,
                questionId = questionId,
                questionNo = questionNo,
                questionNumber = questionNumber,
                questionOccurrence = questionOccurrence,
                questionPoints = questionPoints,
                questionTime = questionTime,
                questionType = questionType,
                status = status,
                //teamAId = teamAId,
                //teamAName = teamAName,
                //teamAScore = teamAScore,
                //teamBId = teamBId,
                //teamBName = teamBName,
                //teamBScore = teamBScore
            )
        }
    }
}
