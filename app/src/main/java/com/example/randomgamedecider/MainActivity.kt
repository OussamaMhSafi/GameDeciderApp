package com.example.randomgamedecider

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.randomgamedecider.databinding.ActivityMainBinding
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )


        binding.addBtn.setOnClickListener {

            val intent= Intent(this, ModifyListActivity::class.java)
            startActivity(intent)

        }

        binding.root

    }

}