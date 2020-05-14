package com.theapache64.cyclone.core.network

import org.json.JSONObject
import retrofit2.Response

class Resource<out T> private constructor(
    val status: Status,
    val statusCode: Int,
    val data: T?,
    val message: String?
) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {

        fun <T> success(data: T?, statusCode: Int): Resource<T> {
            return Resource(
                Status.SUCCESS,
                statusCode,
                data,
                null
            )
        }

        fun <T> error(msg: String, statusCode: Int, data: T? = null): Resource<T> {
            return Resource(
                Status.ERROR,
                statusCode,
                data,
                msg
            )
        }


        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                -1,
                data,
                null
            )
        }

        fun <T> create(status: Status, statusCode: Int, data: T?, message: String?): Resource<T> {
            return Resource(
                status,
                statusCode,
                data,
                message
            )
        }

        /**
         * Create error resource
         */
        fun <T> create(throwable: Throwable, statusCode: Int): Resource<T> {
            return Resource(
                Status.ERROR,
                statusCode,
                null,
                throwable.message ?: "unknown error"
            )
        }

        fun <T> create(response: Response<T>, isNeedDeepCheck: Boolean = false): Resource<T> {

            return if (response.isSuccessful) {
                val body = response.body()
                val statusCode = response.code()
                if (body == null || statusCode == 204) {
                    Resource<T>(
                        Status.SUCCESS,
                        statusCode,
                        null,
                        "No content"
                    )
                } else {
                    if (isNeedDeepCheck) {
                        if (body is BaseApiResponse<*>) {
                            val baseApiResponse = body as BaseApiResponse<*>
                            if (baseApiResponse.error) {
                                Resource<T>(
                                    Status.ERROR,
                                    statusCode,
                                    body,
                                    baseApiResponse.message
                                )
                            } else {
                                Resource<T>(
                                    Status.SUCCESS,
                                    statusCode,
                                    body,
                                    "success"
                                )
                            }
                        } else {
                            Resource<T>(
                                Status.ERROR,
                                statusCode,
                                body,
                                "Body doesn't follow BaseApiResponse standard. DeepCheck not possible"
                            )
                        }

                    } else {
                        Resource(
                            Status.SUCCESS,
                            statusCode,
                            body,
                            "success"
                        )
                    }
                }
            } else {
                val msg = response.errorBody()?.string()

                val errorMsg = if (msg.isNullOrEmpty()) {
                    response.message()
                } else {
                    // Return error string
                    JSONObject(msg).getString("message")
                }
                error(errorMsg ?: "unknown error")
            }
        }
    }
}