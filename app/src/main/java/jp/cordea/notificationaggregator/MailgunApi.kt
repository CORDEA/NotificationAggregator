package jp.cordea.notificationaggregator

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MailgunApi {
    @FormUrlEncoded
    @POST("messages")
    fun postMessage(
            @Field("from") from: String,
            @Field("to") to: String,
            @Field("subject") subject: String,
            @Field("text") text: String
    ): Call<Any>
}
