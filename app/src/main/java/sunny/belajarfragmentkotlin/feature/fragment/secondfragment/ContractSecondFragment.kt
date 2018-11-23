package sunny.belajarfragmentkotlin.feature.fragment.secondfragment

import android.content.Context
import android.view.View
import sunny.belajarfragmentkotlin.entity.model.newsapi.answer
import sunny.belajarfragmentkotlin.rest.News.NewsApi

interface ContractSecondFragment {

    interface mainView {
        fun init(v: View)
        fun action()
        fun updateUi(news: answer)
        fun showLoading()
        fun hideLoading()
    }

    interface presenter {
        fun getNews( ctx: Context, country: String, category: String)
    }

}