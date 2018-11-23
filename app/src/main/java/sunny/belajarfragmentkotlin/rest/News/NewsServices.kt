package sunny.belajarfragmentkotlin.rest.News

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single
import sunny.belajarfragmentkotlin.Constant
import sunny.belajarfragmentkotlin.entity.model.newsapi.answer

interface NewsServices {
    @GET(Constant.NEWS_API_KEYS_COUNTRY)
    fun getNews(@Query("country") country: String,
                @Query("category") category: String,
                @Query("apiKey") apikey: String): Single<answer>
}