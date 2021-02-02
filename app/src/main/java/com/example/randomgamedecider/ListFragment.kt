package com.example.randomgamedecider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment(val s:String) : Fragment() {

    var recyclerView:RecyclerView = TODO()
    var myAdapter: GameAdapter
    var layoutManager:RecyclerView.LayoutManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView = view?.findViewById(R.id.games_list)!!
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this.activity)
        recyclerView.layoutManager=layoutManager
        myAdapter=
            GameAdapter(GameSingleton.instance.allGames)
        recyclerView.adapter=myAdapter

    }

}