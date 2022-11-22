package com.example.myapplication.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class ItemAdapter<T: ItemAdapter.MyViewHolder>(
    val id:Int,
    val data:List<Any?>,
    val classViewHolder:Class<T>,
    val listSize:Int = data.size,
    val list: List<Any?> = listOf()
): RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    abstract class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        abstract fun binViewHolder(list: List<Any?>, position:Int,data: List<Any?>)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(id,null,false)
        val cort = classViewHolder.getConstructor(View::class.java)
        return cort.newInstance(view)
    }

    override fun getItemCount(): Int {
        return listSize
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binViewHolder(list, position, data)
    }

}