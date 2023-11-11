package com.raflis.jkt48app.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.raflis.jkt48app.R

class MemberProfileDetailsActivity : AppCompatActivity() {
    private lateinit var tvName : TextView
    private lateinit var tvGen : TextView
    private lateinit var tvDateOfBirth : TextView
    private lateinit var tvBloodGroup : TextView
    private lateinit var tvHeight : TextView
    private lateinit var ivProfilePicture : ImageView
    private lateinit var ivBack : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_profile_details)

        tvName = findViewById(R.id.tv_name_content)
        tvGen = findViewById(R.id.tv_gen_content)
        tvDateOfBirth = findViewById(R.id.tv_date_content)
        tvBloodGroup = findViewById(R.id.tv_blood_content)
        tvHeight = findViewById(R.id.tv_height_content)
        ivProfilePicture = findViewById(R.id.iv_profile_picture_detail)
        ivBack = findViewById(R.id.iv_back)

        ivBack.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }

        val bundle: Bundle? = intent.extras
        val name = bundle!!.getString("name")
        val gen = bundle.getInt("gen")
        val dateOfBirth = bundle.getString("date_of_birth")
        val bloodGroup = bundle.getString("blood_group")
        val height = bundle.getInt("height")
        val profilePicture = bundle.getString("profile_picture")

        val genText = getString(R.string.gen, gen.toString())
        val heightText = getString(R.string.height, height.toString())

        tvName.text = name
        tvGen.text = genText
        tvDateOfBirth.text = dateOfBirth
        tvBloodGroup.text = bloodGroup
        tvHeight.text = heightText
        Glide.with(this)
            .load(profilePicture)
            .into(ivProfilePicture)

    }
}