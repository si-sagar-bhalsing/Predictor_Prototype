package com.si.f1.library.framework.data.model.response

import com.google.gson.annotations.SerializedName
import com.si.fanalytics.match_predictor.framework.data.model.response.Meta

data class BaseResponseData<V>(
    @SerializedName("Data") val data: BaseResponseValue<V>?,
    @SerializedName("Meta") val meta: Meta?
)

data class BaseResponseValue<V>(
    @SerializedName("Value")
    val value: V?,
)