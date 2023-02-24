package com.example.silversbank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.silversbank.databinding.RecyclerItemExempleBinding
import com.example.silversbank.utils.RecyclerView.News

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listOfNews : List<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemValues = RecyclerItemExempleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewViewHolder(itemValues)

    }

    override fun getItemCount(): Int {
        return  listOfNews.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is NewViewHolder ->{
                holder.bind(listOfNews[position])
            }
        }

    }

    fun addListNews(new: List<News>){
        listOfNews = new
    }


    class NewViewHolder constructor(binding: RecyclerItemExempleBinding) : RecyclerView.ViewHolder(binding.root){
        private val title = binding.textTitleRecycler
        private val description = binding.textDescription


        fun bind(news: News){
            title.setText(news.title)
            description.setText(news.description)
        }
    }
}