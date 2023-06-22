package com.fio.frock.game.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.fio.frock.game.R
import com.fio.frock.game.activity.MainActivity
import com.fio.frock.game.adapter.SingAdapter
import com.fio.frock.game.databinding.FragmentFiveBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


class FiveFragment : Fragment() {

    val binding  by lazy {
        FragmentFiveBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireContext() as MainActivity).goBack = {findNavController().navigate(R.id.action_fiveFragment_to_foureFragment)}
        Log.d("IIIII",listDataApi.toString())

        (requireContext() as MainActivity).binding.Bclose.setOnClickListener{
            var  animator1 =    ObjectAnimator.ofFloat((requireContext() as MainActivity).binding.CVqestion, View.ALPHA, 0F)
            animator1.duration = 500
            animator1.start()

            var  animator6 =    ObjectAnimator.ofFloat(binding.backdroundAlpha, View.ALPHA, 1F)
            animator6.duration = 500
            animator6.start()
        }
        (requireContext() as MainActivity).binding.Bdone.setOnClickListener{
        findNavController().navigate(R.id.action_fiveFragment_to_sevenFragment)
            (requireContext() as MainActivity).binding.CVqestion.alpha = 0F
    }



            getDataApi()


        binding.IVBackFTwo.setOnClickListener{
            findNavController().navigate(R.id.action_fiveFragment_to_foureFragment)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    fun getDataApi() {
        listDataApi = arrayListOf()

        CoroutineScope(Dispatchers.IO).launch {
            var baseUrl = "https://api.deezer.com/search?q=${charDeteil}&type=track"

            val client = OkHttpClient()
            val request = Request.Builder()
                .url(baseUrl)
                .get()
                .build()

            val response = client.newCall(request).execute()
            response.use {
                val responseBody = response.body?.string()

                if (response.isSuccessful && !responseBody.isNullOrEmpty()) {
                    val json = JSONObject(responseBody)
                    val data = json.getJSONArray("data")

                    for (i in 0 until data.length()) {
                        val track = data.getJSONObject(i)
                        val title = track.getString("title")
                        val artist = track.getJSONObject("artist").getString("name")
                        listDataApi.add(ModelMusic(title, artist))
                        Log.d("lllll", "$title by $artist")
                    }
                    withContext(Dispatchers.Main) {
                        binding.progressBar.isVisible = false
                        binding.RVsign.adapter = SingAdapter(listDataApi) {
                            var animator1 = ObjectAnimator.ofFloat(
                                (requireContext() as MainActivity).binding.CVqestion,
                                View.ALPHA,
                                1F
                            )
                            animator1.duration = 500
                            animator1.start()

                            var animator6 =
                                ObjectAnimator.ofFloat(binding.backdroundAlpha, View.ALPHA, 0.5F)
                            animator6.duration = 500
                            animator6.start()

                        }
                    }
                } else {
                    Log.d("aaaaaa", "Error: ${response.code} - ${response.message}")
                }
            }

        }
    }
}