package com.example.islami.hadethFragment

import HadethDetails.HadethDetailsActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.data_model.Hadeth
import com.example.islami.databinding.FragmentHadethBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class HadethFragment : Fragment() {
    lateinit var binding: FragmentHadethBinding
    lateinit var adapter: HadethAdapter
    var ahadeth : MutableList<Hadeth> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadethBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhsdethFile()
        initHadethRecyclerView()
    }

    private fun initHadethRecyclerView() {
        adapter = HadethAdapter(ahadeth){Hadeth,index->
            val intent = Intent(requireActivity(),HadethDetailsActivity::class.java)
            intent.putExtra(HadethDetailsActivity.HADETH_KEY,Hadeth)
            startActivity(intent)
        }
        binding.hadethRecyclerView.adapter = adapter
    }

    fun readAhsdethFile() {
        var reader = BufferedReader(
            InputStreamReader(requireActivity().assets.open("ahadeth/ahadeth.txt"), "UTF-8"))
        val hadeth = mutableListOf<String>()
        var mLine: String?
        mLine = reader.readLine()
        while (mLine!=null) {
            if (!mLine.trim().equals("#")){
                hadeth.add(mLine)
            }else{
                val name = hadeth[0]
                hadeth.removeAt(0)
                val content = hadeth.joinToString(" ")
                ahadeth.add(Hadeth(name,content))
                hadeth.clear()
            }
            mLine = reader.readLine()
        }
    }

}