package com.example.paginationdemo.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(
    private vararg val otherHeaders: Pair<String, String>,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.run {
            proceed(
                request()
                    .newBuilder()
                    .apply {
                        otherHeaders.forEach { header ->
                            addHeader(header.first, header.second)
                        }
                    }.build()
            )
        }
    }
}
