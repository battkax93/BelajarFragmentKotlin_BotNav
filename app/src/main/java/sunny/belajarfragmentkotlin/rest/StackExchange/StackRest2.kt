package sunny.belajarfragmentkotlin.rest.StackExchange

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single
import sunny.belajarfragmentkotlin.BuildConfig
import sunny.belajarfragmentkotlin.Constant
import sunny.testrequestsample.Answer

interface StackRest2 {
    @GET(Constant.STACKEXCHANGES_API_KEYS)
    fun getAllUser(
            @Query("order") order: String,
            @Query("sort") sort: String,
            @Query("site") site: String): Single<Answer>
}