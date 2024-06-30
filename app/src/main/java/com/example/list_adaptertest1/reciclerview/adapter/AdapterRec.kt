package com.example.list_adaptertest1.reciclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.list_adaptertest1.R
import com.example.list_adaptertest1.databinding.ItemLaytoutBinding
import com.example.list_adaptertest1.reciclerview.dataclass.DataClass

class AdapterRec:ListAdapter<DataClass,AdapterRec.MyviewHoldar>(DiffUtil){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHoldar {

        val binding=ItemLaytoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyviewHoldar(binding)
    }

    override fun onBindViewHolder(holder: MyviewHoldar, position: Int) {
       val item=getItem(position)

        holder.bind(item)






    }





    class MyviewHoldar(val binding: ItemLaytoutBinding):RecyclerView.ViewHolder(binding.root){

      fun bind(item:DataClass){


          binding.name.text=item.name

           binding.title.text=item.title
          binding.id.text=item.id.toString()


      }

    }







    companion object{


        val DiffUtil=object : DiffUtil.ItemCallback<DataClass>(){
            override fun areItemsTheSame(oldItem: DataClass, newItem: DataClass): Boolean {

                return oldItem==newItem
            }

            override fun areContentsTheSame(oldItem: DataClass, newItem: DataClass): Boolean {
                return oldItem.id==newItem.id
            }


        }






    }


}