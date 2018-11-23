package sunny.belajarfragmentkotlin.feature.fragment.secondfragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.entity.model.newsapi.answer
import sunny.belajarfragmentkotlin.rest.News.NewsApi
import java.util.*
import kotlin.concurrent.schedule

class SecondFragment : Fragment(), ContractSecondFragment.mainView {

    lateinit var pbar: ProgressBar
    lateinit var second: View
    lateinit var fragFirst: Fragment

    lateinit var api: NewsApi
    lateinit var present: ContractSecondFragment.presenter

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

        api = NewsApi()
        present = PresentSecondFragment(this)
    }

    override fun action() {
    }

    override fun updateUi(news: answer) {
        if (news.status == "ok") {
            Toast.makeText(requireContext(), news.articles[2].title, Toast.LENGTH_SHORT).show()
        }
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