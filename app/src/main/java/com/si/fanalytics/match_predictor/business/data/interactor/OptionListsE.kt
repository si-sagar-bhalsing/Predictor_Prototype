package com.si.fanalytics.match_predictor.business.data.interactor

import com.google.gson.annotations.SerializedName
import com.si.fanalytics.match_predictor.business.domain.model.OptionLists

data class OptionListsE(
    @SerializedName("asset_type") val assetType: String,
    @SerializedName("cf_assetid") val cfAssetId: String,
    @SerializedName("cf_optionid") val cfOptionId: Int,
    @SerializedName("cf_questionid") val cfQuestionId: Int,
    @SerializedName("is_correct") val isCorrect: Int,
    @SerializedName("max_val") val maxVal: Int,
    @SerializedName("min_val") val minVal: Int,
    @SerializedName("option_dec") val optionDec: String,
    @SerializedName("vote_count") val voteCount: Int
)

class OptionListsMapper {
    fun toDomain(entity: OptionListsE): OptionLists {
        return entity.run {
            OptionLists(
                assetType = assetType,
                cfAssetId = cfAssetId,
                cfOptionId = cfOptionId,
                cfQuestionId = cfQuestionId,
                isCorrect = isCorrect,
                maxVal = maxVal,
                minVal = minVal,
                optionDec = optionDec,
                voteCount = voteCount
            )
        }
    }
}
