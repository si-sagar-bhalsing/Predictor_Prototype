package com.si.fanalytics.match_predictor.framework.data.model.response

import com.google.gson.annotations.SerializedName

data class BaseResponseData<V>(
    @SerializedName("Data") val data: BaseResponseValue<V>?,
    @SerializedName("Meta") val meta: Meta?
)

data class BaseResponseValue<V>(
    @SerializedName("Value")
    val value: V?,
)

data class BaseResponse<V>(
    @SerializedName("Data") val data:V?,
    @SerializedName("Meta") val meta: Meta?
)