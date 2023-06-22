package com.fio.frock.game.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.fio.frock.game.R
import com.fio.frock.game.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    val binding by lazy {
        FragmentTwoBinding.inflate(layoutInflater)
    }

    val LOGIN = "0" //= "karaokeFrog22@gmail.com"
    val PASSWORD = "0"// = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.IVcontinie.setOnClickListener{

            if(binding.ETlogin.text.toString() == LOGIN && binding.ETpassword.text.toString() == PASSWORD ){
               findNavController().navigate(R.id.action_twoFragment_to_threeFragment)
            }else {
                binding.IVtop.alpha = 0F
                binding.IVbottom.alpha = 0F
                binding.ETlogin.text.clear()
                binding.ETpassword.text.clear()
                binding.TVeror.isVisible = true
            }
        }

        binding.IVback.setOnClickListener{
            findNavController().navigate(R.id.action_twoFragment_to_oneFragment)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }


}