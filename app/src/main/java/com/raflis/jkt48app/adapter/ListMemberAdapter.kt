package com.raflis.jkt48app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raflis.jkt48app.R
import com.raflis.jkt48app.model.Member

class ListMemberAdapter(private val listMember: List<Member>) : RecyclerView.Adapter<ListMemberAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_members_name)
        val tvGen: TextView = itemView.findViewById(R.id.tv_gen)
        val ivProfilePicture: ImageView = itemView.findViewById(R.id.iv_photo_member)
        val btnToDetailActivity: Button = itemView.findViewById(R.id.btn_to_detail_activity)
    }

    interface OnItemClickListener {
        fun onItemClick(member: Member)
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_members, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMember.size;
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name
        ,dateOfBirth,
         bloodGroup,
        height,
        gen,
        profilePicture) = listMember[position]

        holder.tvName.text = name
        val genText = holder.itemView.context.getString(R.string.gen, gen.toString())
        holder.tvGen.text = genText
        Glide.with(holder.itemView.context)
            .load(profilePicture)
            .into(holder.ivProfilePicture)
        holder.btnToDetailActivity.setOnClickListener {
            itemClickListener?.onItemClick(listMember[position])
        }
    }


}