package com.raflis.jkt48app.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raflis.jkt48app.R
import com.raflis.jkt48app.adapter.ListMemberAdapter
import com.raflis.jkt48app.data.MemberData

class MainActivity : AppCompatActivity() {
    private lateinit var rvMembers : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMembers = findViewById(R.id.rv_members)
        rvMembers.setHasFixedSize(true)

        Log.d("jkt", MemberData.memberDataList.toString())

        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvMembers.layoutManager = LinearLayoutManager(this)
        val listMemberAdapter = ListMemberAdapter(MemberData.memberDataList)
        rvMembers.adapter = listMemberAdapter
    }
}