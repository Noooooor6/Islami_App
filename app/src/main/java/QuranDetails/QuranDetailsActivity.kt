package QuranDetails

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.databinding.ActivityQuranDetailsBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class QuranDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuranDetailsBinding
    companion object{
        val FILE_NAME = "file_name"
        val SURA_NAME = "sura_name"
    }
    lateinit var File_name :String
    lateinit var Sura_name :String
    var ChapterContent = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuranDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        File_name = intent.getStringExtra(QuranDetailsActivity.FILE_NAME)!!
        Sura_name = intent.getStringExtra(QuranDetailsActivity.SURA_NAME)!!
        readFile()
        binding.ChapterContentTv.text = ChapterContent
        binding.ChapterContentTv.movementMethod = ScrollingMovementMethod()
        binding.SuraName.text = Sura_name
    }

    fun readFile() {
        var VersesNumber = 1
        var reader = BufferedReader(
                InputStreamReader(assets.open("quran/${File_name}"), "UTF-8")
            )

            var mLine: String?
            mLine = reader.readLine()
            while (mLine!= null) {
                ChapterContent +=mLine + "{$VersesNumber}"
                mLine = reader.readLine()
                VersesNumber++
            }
    }


}