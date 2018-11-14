package sunny.belajarfragmentkotlin.feature.fragment.firstfragment

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ProgressBar
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.adapter.StackAdapter
import sunny.kotlinmoviechart.entity.model.Item
import android.support.v7.widget.StaggeredGridLayoutManager
import sunny.belajarfragmentkotlin.feature.SpacesItemDecoration


class FirstFragment : ContractFirstFragment.mainView, Fragment() {

    lateinit var mPresenter: ContractFirstFragment.mainPresent
    lateinit var adapter: StackAdapter
    private var itemss: List<Item> = listOf()
    lateinit var pBar: ProgressBar
    lateinit var swp: SwipeRefreshLayout
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val first = inflater.inflate(R.layout.fragment_first, container, false)
        init(first)
        action()
        return first    }


    override fun init(v: View) {

        adapter = StackAdapter(requireContext(), itemss)
        mPresenter = PresentFirstFragment(this)
        pBar = v.findViewById(R.id.mainProgressBar)
        rv = v.findViewById(R.id.rvFootball)
        swp = v.findViewById(R.id.swp_refresh)

        swp.setOnRefreshListener { action() }

    }

    override fun action() {
        mPresenter.getAllUser("desc", "activity", "stackoverflow", requireContext(), adapter)
    }

    override fun updateUi(stck: List<Item>) {
        Log.d("flow", "updateUi")
//        val layoutManager12 = LinearLayoutManager(context)
        val layoutManager12 = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        val spaceDecoration = SpacesItemDecoration(16)
        adapter = StackAdapter(requireContext(), stck)
        rv.layoutManager = layoutManager12
        rv.adapter = adapter
        rv.addItemDecoration(spaceDecoration)
        adapter.notifyDataSetChanged()
        if (swp.isRefreshing) swp.isRefreshing = false

    }

    override fun showLoading() {
        pBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pBar.visibility = View.GONE
    }


}
