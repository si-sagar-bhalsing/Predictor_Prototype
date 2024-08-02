package com.si.fanalytics.match_predictor.business.domain.model


data class Prediction(
  val points: Int?,
  val rank: Int?,
   val matchId: Int?,
   val gamedayId: Int?,
   val retType: Int?,
   val answers: List<Answers>
)


data class Answers(
    val matchId:String,
    val matchPoint:String,
    val optionID:Int,
    val isBooster:Int,
    val qTNAnswers:String,
    val questionId:Int,
)