package sunny.kotlinmoviechart.network.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sunny.belajarfragmentkotlin.BuildConfig


class GithubApi {
    private val gson = GsonBuilder().create()!!
    private val retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.BASE_URL)
            .build()

    val services: Services = retrofit.create(Services::class.java)
}