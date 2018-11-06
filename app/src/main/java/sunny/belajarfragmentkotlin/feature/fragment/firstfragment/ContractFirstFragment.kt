package sunny.belajarfragmentkotlin.feature.fragment.firstfragment

import android.content.Context
import android.view.View
import sunny.belajarfragmentkotlin.adapter.StackAdapter
import sunny.kotlinmoviechart.entity.model.Item

/**
 * Created by Wayan-MECS on 11/5/2018.
 */
interface ContractFirstFragment {
    interface mainView{
        fun init(v: View)
        fun showLoading()
        fun hideLoading()
        fun action()
        fun updateUi(stck: List<Item>)
    }

    interface mainPresent{
        fun getAllUser(order: String,sort: String, site: String, ctx: Context, adapter: StackAdapter)
    }
}