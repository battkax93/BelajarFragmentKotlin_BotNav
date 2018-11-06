package sunny.belajarfragmentkotlin.rest

import retrofit2.http.GET
import retrofit2.http.Query
import sunny.belajarfragmentkotlin.BuildConfig
import sunny.testrequestsample.Answer

/**
 * Created by Wayan-MECS on 11/6/2018.
 */
interface StackRest2 {
    @GET(BuildConfig.BASE_URL2_QUERY)
    fun getAllUser(
            @Query("order") order: String,
            @Query("sort") sort: String,
            @Query("site") site: String): rx.Observable<Answer>
}