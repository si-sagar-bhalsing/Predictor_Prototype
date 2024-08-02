package com.si.fanalytics.match_predictor.framework.data.model.response


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("Maintenance")
    val maintenance: String?,
    @SerializedName("Message")
    val message: String?,
    @SerializedName("RetVal")
    val retVal: Int?,
    @SerializedName("StatusCode")
    val statusCode: Int?,
    @SerializedName("Success")
    val success: Boolean?
)