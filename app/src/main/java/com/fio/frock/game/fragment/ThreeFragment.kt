package com.fio.frock.game.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fio.frock.game.R
import com.fio.frock.game.databinding.FragmentThreeBinding
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class ThreeFragment : Fragment(),ZBarScannerView.ResultHandler {


    val binding by lazy {
        FragmentThreeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding.ZBarScannerView = ZBarScannerView(this)
       binding.ZBarScannerView.setResultHandler(this)
        binding.ZBarScannerView.startCamera()
        binding.IVscan.setOnClickListener{
            var  animator1 =    ObjectAnimator.ofFloat(binding.ZBarScannerView, View.ALPHA, 1F)
            animator1.duration = 500
            animator1.start()
            var  animator2 =    ObjectAnimator.ofFloat(binding.IVscan, View.ALPHA, 0F)
            animator2.duration = 500
            animator2.start()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun handleResult(p0: Result?) {
        Log.d("llll", p0?.contents.toString())
        var  animator1 =    ObjectAnimator.ofFloat(binding.IVresult, View.ALPHA, 1F)
        animator1.duration = 500
        animator1.start()
        binding.TVresult.text = p0?.contents.toString()
        binding.backMenu.text = "BACK"
        var  animator2 =    ObjectAnimator.ofFloat(binding.IVscan, View.ALPHA, 1F)
        animator2.duration = 500
        animator2.start()
        binding.IVscan.setOnClickListener{
            findNavController().navigate(R.id.action_threeFragment_to_oneFragment)
        }


        binding.ZBarScannerView.stopCamera()


    }

    override fun onDestroy() {
        binding.ZBarScannerView.stopCamera()
        super.onDestroy()
    }

}
