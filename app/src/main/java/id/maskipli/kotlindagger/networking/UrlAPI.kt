package id.maskipli.kotlindagger.networking

import id.maskipli.kotlindagger.models.Galaxy
import id.maskipli.kotlindagger.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author nurhidayat
 * @since 07/02/18.
 */

interface UrlAPI {

    @GET(Constant.API_GET_GALAXY)
    fun getGalaxy(@Query("api_key") apiKey: String): Call<Galaxy>

}