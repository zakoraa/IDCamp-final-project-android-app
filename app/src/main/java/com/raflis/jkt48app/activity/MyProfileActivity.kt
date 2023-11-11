package com.raflis.jkt48app.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.raflis.jkt48app.R

class MyProfileActivity : AppCompatActivity() {
    private lateinit var ivBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        ivBack = findViewById(R.id.iv_back)

        ivBack.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
    }
}