package sunny.belajarfragmentkotlin.feature.fragment.firstfragment

import android.content.Context
import android.util.Log
import android.widget.Toast
import io.reactivex.disposables.CompositeDisposable
import rx.schedulers.Schedulers
import sunny.belajarfragmentkotlin.adapter.StackAdapter
import sunny.belajarfragmentkotlin.rest.StackExchange.StackRestApi2


class PresentFirstFragment(val mView: ContractFirstFragment.mainView) : ContractFirstFragment.mainPresent {
    val compositeDisposable = CompositeDisposable()
    lateinit var stckApi: StackRestApi2

    /*override fun getAllUser() {
        mView.showLoading()
        compositeDisposable.add(stckRepositoryImpl.getOwner("desc", "activity", "stackoverflow")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .subscribe {
                    Log.d("flow","succes")
                    own = Arrays.asList(it)
                    mView.hideLoading()
                    mView.updateUi(own)
                }
        )
    }*/

    override fun getAllUser(order: String, sort: String, site: String, ctx: Context, adapter: StackAdapter) {
        Log.d("flow", "getAllUser")
        mView.showLoading()
        stckApi = StackRestApi2()
        stckApi.services.getAllUser(order, sort, site)
                .subscribeOn(Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            mView.hideLoading()
                            Toast.makeText(ctx, "success", Toast.LENGTH_SHORT).show()
                            mView.updateUi(it.items)
                        }, {
                    Log.d("flow", it.toString())
                })
    }
}