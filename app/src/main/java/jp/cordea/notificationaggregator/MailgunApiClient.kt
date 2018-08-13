package jp.cordea.notificationaggregator

import android.util.Base64
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MailgunApiClient : MailgunApi {
    private val header =
            Base64.encodeToString(
                    "api:${BuildConfig.MAILGUN_API_KEY}".toByteArray(),
                    Base64.NO_WRAP
            )

    private val client = OkHttpClient.Builder()
            .addInterceptor {
                it.proceed(it.request()
                        .newBuilder()
                        .addHeader("Authorization", "Basic $header")
                        .build()
                )
            }
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.MAILGUN_DOMAIN)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    override fun postMessage(from: String, to: String, subject: String, text: String): Call<Any> =
            retrofit.create(MailgunApi::class.java).postMessage(from, to, subject, text)
}
