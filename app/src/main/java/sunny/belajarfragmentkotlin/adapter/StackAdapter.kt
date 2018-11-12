package sunny.belajarfragmentkotlin.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.simple_list2.view.*
import sunny.belajarfragmentkotlin.R
import sunny.belajarfragmentkotlin.feature.activity.DetailActivity
import sunny.belajarfragmentkotlin.feature.fragment.secondfragment.SecondFragment
import sunny.kotlinmoviechart.entity.model.Item
import android.support.v4.content.ContextCompat.startActivity
import sunny.belajarfragmentkotlin.feature.activity.DetailDialog
import java.util.*


class StackAdapter(val context: Context, var stckList: List<Item>) : RecyclerView.Adapter<StackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.simple_list2, parent, false))
    }

    override fun getItemCount(): Int = stckList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stckList[position])
        Log.d("flow", itemCount.toString())
    }

    inner class ViewHolder(itView: View) : RecyclerView.ViewHolder(itView) {

        var displayName = itemView.textTest1
        var userType = itemView.textTest2
        var userId = itemView.textTest3
        var ivAva = itemView.ivAva

        fun bind(stck: Item) {
            val url = stck.owner?.profileImage

            displayName.text = stck.owner?.displayName
            userType.text = stck.owner?.userType
            userType.text = stck.owner?.userId.toString()
            Picasso.get().load(stck.owner?.profileImage).into(ivAva)

            itemView.setOnClickListener {
                sendData(displayName.text.toString(),
                        url,
                        userId.text.toString(),
                        userType.text.toString()
                )
            }

            itemView.setOnLongClickListener(View.OnLongClickListener {
                val detailDialog = DetailDialog()
                detailDialog.showDialog(context,
                        url.toString(),
                        displayName.text.toString(),
                        userId.text.toString(),
                        userType.text.toString())
                true
            })
        }
    }

    fun updateList(item: List<Item>) {
        stckList = item
        notifyDataSetChanged()
    }

    fun sendData(name: String, urlAvatar: String?, userType: String, userId: String) {
        Log.d("Flow", "adapter.SendData")

        val bundle = Bundle()
        val i = Intent(context, DetailActivity::class.java)

        bundle.putString("displayName", name)
        bundle.putString("userType", userType)
        bundle.putString("userId", userId)
        bundle.putString("urlAvatar", urlAvatar)

        i.putExtras(bundle)

        startActivity(context, i, bundle)
    }
}