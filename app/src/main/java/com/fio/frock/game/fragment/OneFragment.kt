package com.fio.frock.game.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fio.frock.game.R
import com.fio.frock.game.activity.MainActivity
import com.fio.frock.game.databinding.FragmentOneBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

data class ModelMusic(val music:String, val artist : String )

var listDataApi = arrayListOf<ModelMusic>()

class OneFragment : Fragment() {

val binding by lazy{
    FragmentOneBinding.inflate(layoutInflater)
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireContext() as MainActivity).goBack = {}


        binding.IVplay.setOnClickListener{
            findNavController().navigate(R.id.action_oneFragment_to_foureFragment)
        }

        binding.TVadmin.setOnClickListener{
            findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }


}

