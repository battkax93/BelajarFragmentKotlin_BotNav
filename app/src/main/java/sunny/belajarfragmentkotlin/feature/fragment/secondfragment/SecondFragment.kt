package sunny.belajarfragmentkotlin.feature.fragment.secondfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.adapter.NewsAdapter
import sunny.belajarfragmentkotlin.entity.model.newsapi.answer
import sunny.belajarfragmentkotlin.feature.SpacesItemDecoration
import sunny.belajarfragmentkotlin.rest.News.NewsApi

class SecondFragment : Fragment(), ContractSecondFragment.mainView {

    lateinit var pbar: ProgressBar
    lateinit var second: View
    lateinit var fragFirst: Fragment

    lateinit var api: NewsApi
    lateinit var present: ContractSecondFragment.presenter

    lateinit var adapter: NewsAdapter

    lateinit var swp: SwipeRefreshLayout
    lateinit var rv: RecyclerView
    lateinit var newsss: List<answer.Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        second = inflater.inflate(R.layout.fragment_second, container, false)
        init(second)
        return second
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        present.getNews(api, requireContext(), "id", "business")
    }

    override fun init(v: View) {

        pbar = v.findViewById(R.id.mainProgressBar)
        rv = v.findViewById(R.id.rv_news)
        swp = v.findViewById(R.id.swp_refresh2)
        api = NewsApi()
        present = PresentSecondFragment(this)

        swp.setOnRefreshListener { action() }
    }

    override fun action() {
        Log.d("FLOW", "secondFrag.action")
        present.getNews(api, requireContext(), "id", "business")
    }

    override fun updateUi(news: List<answer.Article>) {

        newsss = news
        Log.d("flow", "updateUi")
        val layoutManager12 = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val spaceDecoration = SpacesItemDecoration(5)
        adapter = NewsAdapter(requireContext(), newsss)
        rv.layoutManager = layoutManager12
        rv.adapter = adapter
//        rv.addItemDecoration(spaceDecoration)
        adapter.notifyDataSetChanged()
        if (swp.isRefreshing) swp.isRefreshing = false

    }

    override fun showLoading() {
        pbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbar.visibility = View.GONE
    }

//    fun tx() {
//        Log.d("flow", "tx")
//        for (i in 1..10) {
//            Timer().schedule(10000) {
//                //delaying 10 s
//                Log.d("tes", "tx")
//            }
//        }
//    }

}