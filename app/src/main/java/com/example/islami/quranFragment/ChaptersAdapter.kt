package com.example.islami.quranFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.data_model.Sura
import com.example.islami.databinding.ChaptersItemBinding

class ChaptersAdapter(val ChapterList : List<Sura>, val onItemClick : (Sura, Int) -> Unit ) :
    Adapter<ChaptersAdapter.ViewHolder>() {

    class ViewHolder(val chaptersItemBinding: ChaptersItemBinding):RecyclerView.ViewHolder(chaptersItemBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ChaptersItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return ChapterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter = ChapterList[position]
        holder.chaptersItemBinding.chapterNameTv.text = chapter.name
        holder.chaptersItemBinding.chapterVersesTv.text = chapter.verses.toString()
        holder.chaptersItemBinding.root.setOnClickListener {
            onItemClick(chapter,position)
        }
    }
}