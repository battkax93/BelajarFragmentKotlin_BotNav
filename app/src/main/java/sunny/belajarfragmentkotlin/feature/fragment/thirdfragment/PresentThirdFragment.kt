package sunny.belajarfragmentkotlin.feature.fragment.thirdfragment

import android.content.Context
import android.util.Log
import android.widget.Toast
import retrofit2.Retrofit
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import sunny.kotlinmoviechart.network.api.GithubApi


class PresentThirdFragment(private var mView: ContractThirdFragment.mainView?) : ContractThirdFragment.mainPresenter {

    override fun getData(api: GithubApi, ctx: Context, un: String) {
        api.services.getUser(un)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            Toast.makeText(ctx, "succes", Toast.LENGTH_SHORT).show()
                            mView?.updateUI(it)
                        }, {
                    Log.e("ERROR", "" + it)
                }
                )
    }
}