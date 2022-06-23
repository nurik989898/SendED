package com.example.sended
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sended.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding:ActivityResultBinding

    companion object {
        const val SEND_DATA = "key"
        const val EXTRA_DATA_NAME = "extra_data_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        catch()
    }
    private fun catch() {
        val desc = intent.getStringExtra(SEND_DATA)
        binding.edSecond.setText(desc)

        binding.btnSecond.setOnClickListener{
            val data = binding.edSecond.text.toString()
            Intent().apply {
                putExtra(EXTRA_DATA_NAME,data)
                setResult(RESULT_OK,this)
                finish()
            }
        }
    }
}