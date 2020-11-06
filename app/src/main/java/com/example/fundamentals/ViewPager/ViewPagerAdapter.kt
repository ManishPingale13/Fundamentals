package com.example.fundamentals.ViewPager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fundamentals.R
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter(private val images: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.MyVPHolder>() {

    inner class MyVPHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVPHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return MyVPHolder(view)
    }

    override fun onBindViewHolder(holder: MyVPHolder, position: Int) {
        val currentimage = images[position]
        holder.itemView.myimage.setImageResource(currentimage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}