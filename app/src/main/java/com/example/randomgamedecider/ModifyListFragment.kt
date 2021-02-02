package com.example.randomgamedecider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.randomgamedecider.databinding.FragmentModifyListBinding


class ModifyListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val binding:FragmentModifyListBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_modify_list, container, false)
        return binding.root
    }

}