package sunny.kotlinmoviechart.network.api

import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable
import sunny.belajarfragmentkotlin.entity.model.Github

interface Services {
    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Observable<Github>
}