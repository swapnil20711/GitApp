package com.swapnil.gitapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import com.swapnil.gitapp.databinding.ActivityMainBinding
import com.swapnil.gitapp.model.User
import com.swapnil.gitapp.network.RetrofitInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        RetrofitInstance.gitApi.getUser().enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                if (response.isSuccessful) {
                    updateUI(response.body())
                } else {
                    updateUIWhenErrorOccurs(response.errorBody())
                }
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                when (t) {
                    is IOException ->
                        binding.apply {
                            noInternetTxt.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                            noInternetTxt.text = "Check your internet connection!!"
                        }
                }
            }
        })
    }

    private fun updateUI(user: User?) {
        binding.apply {
            viewGroup.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            followersCnt.text = user?.followers.toString()
            followingCnt.text = user?.following.toString()
            gitImage.load(user?.avatar_url) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }

    }

}

private fun updateUIWhenErrorOccurs(errorBody: ResponseBody?) {
    binding.apply {
        noInternetTxt.visibility = View.VISIBLE
        noInternetTxt.text = errorBody.toString()
        progressBar.visibility = View.GONE
    }
}
