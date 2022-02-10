package com.yuyakaido.android.cardstackview.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CardStackAdapter(
        private var htmlList: List<String> = emptyList()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_spot, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val htmlString = htmlList[position]
        val mimeType = "text/html"
        val encoding = "UTF-8"

        holder.vwContainer.loadDataWithBaseURL("", htmlString, mimeType, encoding, "")
        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, "$position Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return htmlList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vwContainer :WebView = view.findViewById(R.id.wvContainer)
    }

}
