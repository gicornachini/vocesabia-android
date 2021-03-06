package giovannicornachini.vocesabia

import com.google.gson.JsonObject
import giovannicornachini.vocesabia.Models.Question
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by giovannicornachini on 23/09/17.
 */

object SimulandoAPIHelper {
    private val API_URL = "http://10.0.2.2:8000"

    interface SimulandoAPI {

        @GET("/api/v1/questions/")
        fun questions(): Call<List<Question>>

        @POST("/api/v1/leads/")
        @FormUrlEncoded
        fun leadCapture(@Field("email") email: String): Call<JsonObject>
    }

    // Retrofit client
    val client: Retrofit
        get() {

            return Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

    // Init Simulando API
    val api: SimulandoAPI
        get() {

            return client.create(SimulandoAPI::class.java)
        }

}
