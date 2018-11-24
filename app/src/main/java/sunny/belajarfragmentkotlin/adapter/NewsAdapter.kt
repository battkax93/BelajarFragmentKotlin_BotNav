package sunny.belajarfragmentkotlin.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.entity.model.newsapi.answer
import sunny.belajarfragmentkotlin.feature.activity.NewsDetailActivity

/**
 * Created by BLACK on 24/11/2018.
 */
class NewsAdapter(val ctx: Context, var newsList: List<answer.Article>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.news_item, p0, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        holder.bind(newsList[p1])
    }

    override fun getItemCount(): Int = newsList.size

    inner class ViewHolder(itView: View) : RecyclerView.ViewHolder(itView) {

        var ImagesNews = itView.iv_news
        var NewsTitles = itView.news_title
        var NewsDesc = itView.news_desc
        var cv = itView.cv_news

        fun bind(news: answer.Article) {
            Picasso.get().load(news.urlToImage).error(R.drawable.ic_launcher_foreground).into(ImagesNews)
            NewsTitles.text = news.title
            NewsDesc.text = news.description

            itemView.setOnClickListener {
                sendData(news.urlToImage, news.description, news.url, news.title)
                Log.d("FLOW", "cv clicked")
            }
        }
    }

    fun sendData(urlNewsImage: String, newsDesc: String, sourceNews: String, titleNews: String) {
        Log.d("Flow", "adapter.SendData")

        val bundle = Bundle()
        val i = Intent(ctx, NewsDetailActivity::class.java)

        bundle.putString("ivPic", urlNewsImage)
        bundle.putString("newsDesc", newsDesc)
        bundle.putString("sourceNews", sourceNews)
        bundle.putString("titleNews", titleNews)

        i.putExtras(bundle)
        ContextCompat.startActivity(ctx, i, bundle)
    }
}