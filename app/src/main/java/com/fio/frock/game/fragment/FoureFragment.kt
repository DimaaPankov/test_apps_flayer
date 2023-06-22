package com.fio.frock.game.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fio.frock.game.R
import com.fio.frock.game.activity.MainActivity
import com.fio.frock.game.databinding.FragmentFoureBinding

var charDeteil = ""
class FoureFragment : Fragment() {

    val binding by lazy {FragmentFoureBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireContext() as MainActivity).goBack = {findNavController().navigate(R.id.action_foureFragment_to_oneFragment)}


        binding.a.setOnClickListener{ charDeteil = "a";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.b .setOnClickListener{charDeteil = "b";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.c .setOnClickListener{charDeteil = "c";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.d .setOnClickListener{charDeteil = "d";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.e .setOnClickListener{charDeteil = "e";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.f .setOnClickListener{charDeteil = "f";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.g .setOnClickListener{charDeteil = "g";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.h .setOnClickListener{charDeteil = "h";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.i .setOnClickListener{charDeteil = "i";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.j .setOnClickListener{charDeteil = "j";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.k .setOnClickListener{charDeteil = "k";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.l .setOnClickListener{charDeteil = "l";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.m .setOnClickListener{charDeteil = "m";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.n .setOnClickListener{charDeteil = "n";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.o .setOnClickListener{charDeteil = "o";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.p .setOnClickListener{charDeteil = "p";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.q .setOnClickListener{charDeteil = "q";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.r .setOnClickListener{charDeteil = "r";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.s .setOnClickListener{charDeteil = "s";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.t .setOnClickListener{charDeteil = "t";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.u .setOnClickListener{charDeteil = "u";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.v .setOnClickListener{charDeteil = "v";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.w .setOnClickListener{charDeteil = "w";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}
        binding.x .setOnClickListener{charDeteil = "x";findNavController().navigate(R.id.action_foureFragment_to_fiveFragment)}

       binding.IVBackFTwo.setOnClickListener{
           findNavController().navigate(R.id.action_foureFragment_to_oneFragment)
       }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }


}