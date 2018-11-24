package sunny.belajarfragmentkotlin.feature.fragment.secondfragment

import android.content.Context
import android.view.View
import sunny.belajarfragmentkotlin.entity.model.newsapi.answer
import sunny.belajarfragmentkotlin.rest.News.NewsApi

interface ContractSecondFragment {

    interface mainView {
        fun init(v: View)
        fun action()
        fun updateUi(news: List<answer.Article>)
        fun showLoading()
        fun hideLoading()
    }

    interface presenter {
        fun getNews(api: NewsApi, ctx: Context, country: String, category: String)
    }

}