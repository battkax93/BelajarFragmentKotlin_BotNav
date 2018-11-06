package sunny.belajarfragmentkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.simple_list2.view.*
import sunny.belajarfragmentkotlin.R
import sunny.kotlinmoviechart.entity.model.Item


class StackAdapter(val context: Context, var stckList: List<Item>) : RecyclerView.Adapter<StackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.simple_list2, parent, false))
    }

    override fun getItemCount(): Int = stckList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stckList[position])
        Log.d("flow",itemCount.toString())
    }

    inner class ViewHolder(itView: View) : RecyclerView.ViewHolder(itView) {

        fun bind(stck: Item) {
            itemView.textTest1.text = stck.owner?.displayName
            itemView.textTest2.text = stck.owner?.userType
            itemView.textTest3.text = stck.owner?.userId.toString()
            Picasso.get().load(stck.owner?.profileImage).into(itemView.ivAva)

            itemView.setOnClickListener {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateList(item: List<Item>) {
        stckList = item
        notifyDataSetChanged()
    }
}