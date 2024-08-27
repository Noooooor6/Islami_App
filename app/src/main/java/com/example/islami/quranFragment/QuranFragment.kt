package com.example.islami.quranFragment

import QuranDetails.QuranDetailsActivity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.data_model.Sura
import com.example.islami.databinding.FragmentQuranBinding

class QuranFragment : Fragment() {
    lateinit var binding : FragmentQuranBinding
    lateinit var adapter: ChaptersAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuranBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV()
    }

    private fun initRV() {
        adapter = ChaptersAdapter(Sura.surasList){ Sura, index->
            val intent = Intent(requireActivity(), QuranDetailsActivity::class.java)
            intent.putExtra(QuranDetailsActivity.SURA_NAME,Sura.name)
            intent.putExtra(QuranDetailsActivity.FILE_NAME, "${index+1}.txt")
            startActivity(intent)
        }
        binding.ChaptersRV.adapter = adapter
    }

}