package com.zhai.mvpdemo.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.zhai.mvpdemo.R

/**
 * Created by zhai on 16/6/18.
 */

class NoteAdapter(private val list: List<String>?, private val listener: NoteAdapter.DeleteButtonListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_item, null, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.tv.text = list!![position]
        viewHolder.bn.setOnClickListener { listener.onDeleteButtonClick(position) }
    }

    override fun getItemCount(): Int {
        return if (list == null) 0 else list.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv: TextView
        var bn: Button

        init {
            tv = itemView.findViewById(R.id.content) as TextView
            bn = itemView.findViewById(R.id.remove) as Button
        }
    }

    interface DeleteButtonListener {
        fun onDeleteButtonClick(position: Int)
    }
}
