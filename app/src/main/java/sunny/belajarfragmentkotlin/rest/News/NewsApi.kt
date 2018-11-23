package sunny.belajarfragmentkotlin.rest.News

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sunny.belajarfragmentkotlin.Constant
import okhttp3.HttpUrl
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class NewsApi {
    private val gson = GsonBuilder().create()!!
    var retrofit: Retrofit = getClient()

    fun getClient(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        if (retrofit == null) {
            val ok = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            retrofit = Retrofit.Builder()
                    .baseUrl(Constant.NEWS_API_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(ok.newBuilder().connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .build())
                    .build()
        }
        return retrofit
    }

    val services: NewsServices = retrofit.create(NewsServices::class.java)
}