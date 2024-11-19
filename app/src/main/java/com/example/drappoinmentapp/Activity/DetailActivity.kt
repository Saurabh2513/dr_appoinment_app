package com.example.drappoinmentapp.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.drappoinmentapp.Model.DoctorsModel
import com.example.drappoinmentapp.R
import com.example.drappoinmentapp.databinding.ActivityDetailBinding
import java.util.ResourceBundle.getBundle

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    private lateinit var item : DoctorsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getBundle()

    }

    private fun getBundle() {
        item = intent.getParcelableExtra("0")!!
        binding.apply {
            specialTxt.text = item.Special
            patiensTxt.text = item.Patiens
            bioTxt.text = item.Biography
            addressTxt.text = item.Address
            timeTxt.text = item.Time
            dateTxt.text = item.Date

            experiensTxt.text = item.Experience.toString() + "Years"
            ratingTxt.text = "${item.Rating}"
            backBtn.setOnClickListener {
                finish()
                websiteBtn.setOnClickListener {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.setData(Uri.parse(item.Site))
                    startActivity(i)
                }
                massegeBtn.setOnClickListener {
                    val uri = Uri.parse("smsto:${item.Mobile}")
                    val intent = Intent(Intent.ACTION_SENDTO,uri)
                    intent.putExtra("sms_dody","the SMS text")
                    startActivity(intent)
                }
                callBtn.setOnClickListener {
                    val uri = "tel:"+item.Mobile.trim()
                    val intent  = Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse(uri)
                    )
                    startActivity(intent)
                }
                directionBtn.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW,
                        Uri.parse(item.Location)
                        )
                }
            }
        }
    }
}