package com.example.sended

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sended.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    companion object {
        const val SEND_DATA = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sendData()
    }

    private fun sendData() {
        val resultContract =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                if (result.data != null) {
                  val ceo = result.data?.getStringExtra(ResultActivity.EXTRA_DATA_NAME)
                  binding.edFirst.setText(ceo)
                }
            }

        binding.btnFirst.setOnClickListener {
            if (binding.edFirst.text.trim().isEmpty()){
                Toast.makeText(this,getString(R.string.Send),Toast.LENGTH_SHORT).show()
            }else{
                Intent(this, ResultActivity::class.java).apply {
                    putExtra(SEND_DATA,binding.edFirst.text.toString())
                    resultContract.launch(this)
                }
            }
        }
    }
}
