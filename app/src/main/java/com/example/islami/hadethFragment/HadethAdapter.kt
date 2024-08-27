package com.example.islami.hadethFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.data_model.Hadeth
import com.example.islami.databinding.HadethItemBinding

class HadethAdapter(val hadeth : List<Hadeth>, val onItemClick : (Hadeth,Int) -> Unit): RecyclerView.Adapter<HadethAdapter.ViewHolder>() {

    class ViewHolder(val hadethItemBinding: HadethItemBinding):RecyclerView.ViewHolder(hadethItemBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HadethItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hadeth.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadeth[position]
        holder.hadethItemBinding.HadethTv.text = hadeth.name
        holder.hadethItemBinding.root.setOnClickListener {
            onItemClick(hadeth,position)
        }
    }
}