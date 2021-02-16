package com.example.randomgamedecider

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.randomgamedecider.databinding.ActivityModifyListBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class ModifyListActivity : AppCompatActivity() {

    private var mExampleList: ArrayList<Game1>? = null
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var addBtn: Button? = null
    private var genreEditText: TextInputEditText? = null
    private var titleEditText: TextInputEditText? = null
    private lateinit var gameSingleton:GameSingleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gameSingleton= GameSingleton.getInstance()
        loadData()
        gameSingleton.setGames(mExampleList)

        val binding=DataBindingUtil.setContentView<ActivityModifyListBinding>(
            this, R.layout.activity_modify_list
        )

        mRecyclerView = binding.recyclerView
        mRecyclerView?.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        mAdapter = GameAdapter(mExampleList!!)
        mRecyclerView!!.setLayoutManager(mLayoutManager)
        mRecyclerView!!.setAdapter(mAdapter)

        createGameList()
        addBtn = binding.addBtn
        genreEditText = binding.genreEditText
        titleEditText = binding.titleEditText

        addBtn!!.setOnClickListener {

            saveData()

            insertItem(
                titleEditText!!.text.toString(),
                genreEditText!!.text.toString(),
                R.mipmap.ic_launcher_round
            )
        }

        binding.root
    }


    fun insertItem(title: String, genre: String, imgURL: Int) {
        mExampleList!!.add(Game1(title, genre, imgURL))
        mAdapter?.notifyItemInserted(mExampleList!!.size)
    }

    private fun createGameList() {
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(mExampleList)
        editor.putString("task list", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("task list", null)
        val type: Type = object : TypeToken<ArrayList<Game1?>?>() {}.type
        mExampleList = gson.fromJson<ArrayList<Game1>>(json, type)
        if (mExampleList == null) {
            mExampleList = ArrayList()
        }
    }
}