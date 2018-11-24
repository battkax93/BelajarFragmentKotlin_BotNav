package sunny.belajarfragmentkotlin.feature.activity

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.content_news_detail.*
import sunny.belajarfragmentkotlin.R

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        init()
        appBarListener()
    }

    fun init() {
        Picasso.get().load(intent.extras.getString("ivPic")).into(iv_detail_news)
        tv_news_detail_desc.text = intent.extras.getString("newsDesc")
        source_link_news_detail.text = intent.extras.getString("sourceNews")
    }

    fun appBarListener() {
        setSupportActionBar(toolbar_detauls_news)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar_detauls_news.setBackgroundColor(Color.TRANSPARENT)

        toolbar_layout.title = " "
        toolbar_layout.setBackgroundColor(Color.TRANSPARENT)

        app_bar_news.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                Log.d("flow", "collapse")
                toolbar_detauls_news.visibility = View.VISIBLE
            } else {
                Log.d("flow", "expanded")
                toolbar_detauls_news.visibility = View.INVISIBLE
            }
        })
    }

}
