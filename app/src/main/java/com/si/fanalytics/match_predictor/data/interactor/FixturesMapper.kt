package com.si.fanalytics.match_predictor.data.interactor

import com.google.gson.annotations.SerializedName
import com.si.fanalytics.match_predictor.data.model.Data
import com.si.fanalytics.match_predictor.data.model.FeedTime
import com.si.fanalytics.match_predictor.data.model.Meta
import com.si.fanalytics.match_predictor.data.model.PredictorModel
import com.si.fanalytics.match_predictor.data.model.Timestamp

data class FeedTimeE(
    @SerializedName("CESTTime") val cestTime: String,
    @SerializedName("ISTTime") val istTime: String,
    @SerializedName("UTCTime") val utcTime: String
)

class FeedTimeMapper {
    fun toDomain(apiModel: FeedTimeE): FeedTime {
        return FeedTime(
            CESTTime = apiModel.cestTime,
            ISTTime = apiModel.istTime,
            UTCTime = apiModel.utcTime
        )
    }
}


data class MetaE(
    @SerializedName("Message") val message: String,
    @SerializedName("RetVal") val retVal: Int,
    @SerializedName("Success") val success: Boolean,
    @SerializedName("Timestamp") val timestamp: TimestampE
)

class MetaMapper(private val timestampMapper: TimestampMapper) {
    fun toDomain(apiModel: MetaE): Meta {
        return Meta(
            Message = apiModel.message,
            RetVal = apiModel.retVal,
            Success = apiModel.success,
            Timestamp = timestampMapper.toDomain(apiModel.timestamp)
        )
    }
}


data class TimestampE(
    @SerializedName("CESTTime") val cestTime: String,
    @SerializedName("ISTTime") val istTime: String,
    @SerializedName("UTCTime") val utcTime: String
)

class TimestampMapper {
    fun toDomain(apiModel: TimestampE): Timestamp {
        return Timestamp(
            CESTTime = apiModel.cestTime,
            ISTTime = apiModel.istTime,
            UTCTime = apiModel.utcTime
        )
    }
}


data class DataE(
    @SerializedName("FeedTime") val feedTime: FeedTimeE,
    @SerializedName("Value") val value: List<ValueE>
)

class DataMapper(private val feedTimeMapper: FeedTimeMapper, private val valueMapper: ValueMapper) {
    fun toDomain(apiModel: DataE): Data {
        return Data(
            FeedTime = feedTimeMapper.toDomain(apiModel.feedTime),
            Value = apiModel.value.map { valueMapper.toDomain(it) }
        )
    }
}

data class PredictorModelE(
    @SerializedName("Data") val data: DataE,
    @SerializedName("Meta") val meta: MetaE
)

class PredictorModelMapper(private val dataMapper: DataMapper, private val metaMapper: MetaMapper) {
    fun toDomain(apiModel: PredictorModelE): PredictorModel {
        return PredictorModel(
            Data = dataMapper.toDomain(apiModel.data),
            Meta = metaMapper.toDomain(apiModel.meta)
        )
    }
}
