package com.example.islami.sebhaFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSebhaBinding


class SebhaFragment() : Fragment() {

    lateinit var binding: FragmentSebhaBinding
    var counter = 0
    val Zekr = listOf<String>("الحمد لله", "الله اكبر", "سبحان الله")
    var currentIndex = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sebha_process()
    }

    fun sebha_process() {
        binding.sebhaBody.setOnClickListener {
            rotateView(binding.sebhaBody)
            counter++
            binding.tasbehCounterTv.text = counter.toString()
            if (counter == 33) {
                counter = 0
                binding.zekrTv.text = Zekr[currentIndex]
                currentIndex = (currentIndex + 1) % Zekr.size
            }
        }
    }

    private fun rotateView(view: View) {
        view.animate().rotationBy(12f)
            .setDuration(500).start()
    }
}
