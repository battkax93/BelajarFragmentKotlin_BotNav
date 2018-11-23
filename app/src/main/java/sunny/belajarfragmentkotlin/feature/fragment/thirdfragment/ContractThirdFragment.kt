package sunny.belajarfragmentkotlin.feature.fragment.thirdfragment

import android.content.Context
import sunny.belajarfragmentkotlin.entity.model.Github.Github
import sunny.kotlinmoviechart.network.api.GithubApi

interface ContractThirdFragment {
    interface mainView {
        fun init()
        fun action()
        fun updateUI(user: Github)
    }

    interface mainPresenter {
        fun getData(api: GithubApi, ctx: Context, un: String)
    }
}