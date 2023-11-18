package com.example.hotel.api

import com.example.domain.models.ResponseResult
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

private const val RESPONSE_MESSAGE = "message"

/**
 * Обертка для обработки запросов к API
 *
 * @param call запрос к API
 */
suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>) = try {
    val response = call.invoke()
    if (response.isSuccessful) {
        ResponseResult.Success(response.body())
    } else {
        val message = try {
            val jsonObject = response.errorBody()?.string()?.let { JSONObject(it) }
            jsonObject?.getString(RESPONSE_MESSAGE)
        } catch (_: JSONException) {
            null
        }
        ResponseResult.Failure(message = message ?: "", code = response.code())
    }
} catch (exception: IOException) {
    ResponseResult.Error(exception)
}