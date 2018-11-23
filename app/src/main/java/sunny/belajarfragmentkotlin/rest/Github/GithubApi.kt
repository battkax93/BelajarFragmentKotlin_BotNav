package sunny.kotlinmoviechart.network.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sunny.belajarfragmentkotlin.BuildConfig
import sunny.belajarfragmentkotlin.Constant


class GithubApi {
    private val gson = GsonBuilder().create()!!
    private val retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constant.GITHUB_API_URL)
            .build()

    val services: Services = retrofit.create(Services::class.java)
}