package id.maskipli.kotlindagger.networking

import id.maskipli.kotlindagger.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author nurhidayat
 * @since 07/02/18.
 */
class RestClient {

    companion object {

        private val okHttpInterceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BASIC)

        private val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(okHttpInterceptor)
                .build()

        private var retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()

        var apiUrl: UrlAPI = retrofit.create(UrlAPI::class.java)
    }
}