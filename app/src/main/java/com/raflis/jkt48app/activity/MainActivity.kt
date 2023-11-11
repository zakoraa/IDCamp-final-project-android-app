package com.raflis.jkt48app.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raflis.jkt48app.R
import com.raflis.jkt48app.adapter.ListMemberAdapter
import com.raflis.jkt48app.data.MemberData
import com.raflis.jkt48app.model.Member

class MainActivity : AppCompatActivity() {
    private lateinit var rvMembers : RecyclerView
    private lateinit var ivToMyProfile : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivToMyProfile = findViewById(R.id.iv_to_my_profile)
        rvMembers = findViewById(R.id.rv_members)
        rvMembers.setHasFixedSize(true)


        rvMembers.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = ListMemberAdapter(MemberData.memberDataList)
        rvMembers.adapter = listMemberAdapter

        ivToMyProfile.setOnClickListener{
            val intent = Intent(this@MainActivity, MyProfileActivity::class.java)
            startActivity(intent)
        }

        listMemberAdapter.setOnItemClickListener(object: ListMemberAdapter.OnItemClickListener{
            override fun onItemClick(member: Member) {
                val intent = Intent(this@MainActivity, MemberProfileDetailsActivity::class.java)
                intent.putExtra("name",member.name )
                intent.putExtra("gen",member.gen )
                intent.putExtra("date_of_birth",member.dateOfBirth )
                intent.putExtra("blood_group",member.bloodGroup )
                intent.putExtra("height",member.height )
                intent.putExtra("profile_picture", member.profilePicture)
                startActivity(intent)
            }
        })
    }


}