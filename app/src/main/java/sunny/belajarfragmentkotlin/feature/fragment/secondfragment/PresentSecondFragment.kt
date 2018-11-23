package sunny.belajarfragmentkotlin.feature.fragment.secondfragment

import android.content.Context
import android.util.Log
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import sunny.belajarfragmentkotlin.Constant
import sunny.belajarfragmentkotlin.rest.News.NewsApi


class PresentSecondFragment(val mView: ContractSecondFragment.mainView) : ContractSecondFragment.presenter {

    private val apiKeys = Constant.NEWS_KEY
    lateinit var api: NewsApi

    override fun getNews(ctx: Context, country: String, category: String) {
        Log.d("FLOW", "$apiKeys ,$country ,$category")
        Log.d("FLOW", "getNews")
        mView.showLoading()
        api = NewsApi()
        api.services.getNews(country, category, apiKeys)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView.hideLoading()
                    Log.d("FLOW", "" + it.articles[2].title)
                    mView.updateUi(it)
                }, {
                    mView.hideLoading()
                    Log.e("error", "" + it.toString())
                })

    }

}