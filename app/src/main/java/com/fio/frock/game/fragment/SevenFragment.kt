package com.fio.frock.game.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.fio.frock.game.R
import com.fio.frock.game.activity.MainActivity
import com.fio.frock.game.adapter.qrData
import com.fio.frock.game.databinding.FragmentSevenBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

class SevenFragment : Fragment() {


    val binding by lazy{
        FragmentSevenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       startTimer(0.5F,binding.TVtimer)

        (requireContext() as MainActivity).goBack = {findNavController().navigate(R.id.action_sevenFragment_to_fiveFragment)}

        val count = (1..50).random().toString()

        generateQR(qrData)

        binding.TVnamber.text = count
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }



    private fun generateQR( str:String) {
        val writer = MultiFormatWriter()
        try {
            val matrix = writer.encode(str, BarcodeFormat.QR_CODE, 600, 600)
            val encoder = BarcodeEncoder()
            val bitmap = encoder.createBitmap(matrix)
            binding.IVqrCode.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            e.printStackTrace()
        }
    }

    fun startTimer(minutes: Float, textView: TextView) {
        val totalSeconds = minutes * 60F
        var remainingSeconds = totalSeconds

        val handler = android.os.Handler()
        val runnable = object : Runnable {
            override fun run() {
                val secondsLeft = remainingSeconds % 60F

                textView.text = "${(secondsLeft/10F).toInt()} ${(secondsLeft%10F).toInt()}"

                if (remainingSeconds > 0) {
                    remainingSeconds--
                    handler.postDelayed(this, 1000) // Schedule the next update after 1 second
                } else {
                    var  animator1 =    ObjectAnimator.ofFloat(binding.IVresult, View.ALPHA, 1F)
                    animator1.duration = 500
                    animator1.start()

                    var  animator2 =    ObjectAnimator.ofFloat(binding.backgroundA, View.ALPHA, 0.5F)
                    animator2.duration = 500
                    animator2.start()

                    binding.IVscan.setOnClickListener{
                        findNavController().navigate(R.id.action_sevenFragment_to_oneFragment)
                    }
                }
            }
        }

        handler.post(runnable) // Start the timer
    }


}