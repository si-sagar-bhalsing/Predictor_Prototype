package com.si.fanalytics.match_predictor.business.data.utils

/**
 * Sealed class which have two type i.e
 * 1. [Success] -> when a repository successfully fetch and is able to provide data
 * 2. [Error] -> when there's an error while fetching or exception occurs while fetching or storing data.
 * This will be returned by repository methods only
 */
sealed class Resource<out T> {

    data class Success<T>(val data: T) : Resource<T>()

    data class Error<T>(val throwable: CustomThrowable) : Resource<T>()

}


open class CustomThrowable(val code: Int? = 0, message: String) : Throwable(message)
