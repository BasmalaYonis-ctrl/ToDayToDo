//package com.example.yarabs10
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.yarabs10.databinding.FragmentListBinding
//import com.example.yarabs10.databinding.ItemDesignBinding
//
//class myAdapter(var list:List<user>,
//                private val onDelete: (user) -> Unit,
//                private val onUpdate: (user) -> Unit):RecyclerView.Adapter<myAdapter.myHolder>(){
//    class myHolder(val binding:ItemDesignBinding):RecyclerView.ViewHolder(binding.root){
//        fun bindData(User: user){
//            binding.name.text= User.name
//            binding.email.text= User.email
//            binding.phone.text= User.phone
//            binding.delete.setOnClickListener {
//                onDelete(user)
//            }
//
//            binding.edit.setOnClickListener {
//                onUpdate(user)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
//        val binding=ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return myHolder(binding)
//    }
//
//    override fun getItemCount()=list.size
//
//    override fun onBindViewHolder(holder: myHolder, position: Int) {
//        holder.bindData(list[position])
//    }
//    fun updateList(newList: List<user>) {
//        list = newList
//        notifyDataSetChanged()
//    }
//
//}
package com.example.ToDayToDo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ToDayToDo.databinding.ItemDesignBinding

class myAdapter(
    private var list: List<user>,
    private val onDelete: (user) -> Unit,
    private val onUpdate: (user) -> Unit
) : RecyclerView.Adapter<myAdapter.myHolder>() {

    inner class myHolder(private val binding: ItemDesignBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(user: user) {
            binding.name.text = user.name
            binding.email.text = user.email
            binding.phone.text = user.phone

            binding.delete.setOnClickListener {
                onDelete(user)
            }

            binding.edit.setOnClickListener {
                onUpdate(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val binding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        holder.bindData(list[position])
    }

    fun updateList(newList: List<user>) {
        list = newList
        notifyDataSetChanged()
    }
}
