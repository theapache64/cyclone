package com.theapache64.cyclone.core.network.flow

import com.theapache64.cyclone.core.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.awaitResponse
import java.lang.reflect.Type

/**
 * To convert retrofit response to Flow<Resource<T>>.
 * Inspired from FlowCallAdapterFactory
 */
class FlowResourceCallAdapter<R>(
    private val responseType: Type,
    private val isNeedDeepCheck: Boolean,
    private val isSelfExceptionHandling: Boolean
) : CallAdapter<R, Flow<Resource<R>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): Flow<Resource<R>> = flow {

        emit(Resource.loading())

        var respCode: Int = -1
        try {
            val resp = call.awaitResponse()
            respCode = resp.code()
            if (resp.isSuccessful) {
                emit(Resource.create(resp, isNeedDeepCheck))
            } else {
                emit(Resource.create<R>(Throwable(resp.message()), respCode))
            }
        } catch (e: Throwable) {
            if (isSelfExceptionHandling) {
                emit(Resource.create<R>(e, respCode))
            } else {
                throw e
            }
        }
    }
}