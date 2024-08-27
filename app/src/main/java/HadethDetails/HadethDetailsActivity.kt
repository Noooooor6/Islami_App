package HadethDetails

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami.R
import com.example.islami.data_model.Hadeth
import com.example.islami.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {
    companion object{
        val HADETH_KEY = "hadeth"
    }
    lateinit var binding: ActivityHadethDetailsBinding
    lateinit var hadeth: Hadeth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getSerializableExtra(HADETH_KEY,Hadeth::class.java)!!
        } else {
            hadeth = intent.getSerializableExtra(HADETH_KEY)as Hadeth
        }
        binding.hadethName.text = hadeth.name
        binding.HadethContentTv.text = hadeth.content
    }
}