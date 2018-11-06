package sunny.belajarfragmentkotlin.feature.fragment.firstfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.adapter.StackAdapter
import sunny.kotlinmoviechart.entity.model.Item

class FirstFragment : ContractFirstFragment.mainView, Fragment() {

    lateinit var mPresenter: ContractFirstFragment.mainPresent
    lateinit var adapter: StackAdapter
    private var itemss: List<Item> = listOf()
    lateinit var pBar: ProgressBar
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val first = inflater!!.inflate(R.layout.fragment_first, container, false)
        init(first)
        action()
        return first
    }

    override fun init(v: View) {

        adapter = StackAdapter(context, itemss)
        mPresenter = PresentFirstFragment(this)
        pBar = v.findViewById(R.id.mainProgressBar)
        rv = v.findViewById(R.id.rvFootball)

    }

    override fun action() {
        mPresenter.getAllUser("desc", "activity", "stackoverflow", context, adapter)
    }

    override fun updateUi(stck: List<Item>) {
        Log.d("flow", "updateUi")
        val layoutManager = LinearLayoutManager(context)
        adapter = StackAdapter(context, stck)
        rv.layoutManager = layoutManager
        rv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        pBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pBar.visibility = View.GONE
    }

}
