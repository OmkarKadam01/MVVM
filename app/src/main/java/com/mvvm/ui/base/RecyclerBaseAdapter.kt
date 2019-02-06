package com.mvvm.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mvvm.BR


abstract class RecyclerBaseAdapter<T> : RecyclerView.Adapter<RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
            RecyclerViewHolder(DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context),viewType,parent,false))


    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        getViewModel(position)?.let {
            val bindingStatus=holder.binding.setVariable(BR._all,it)
            if(!bindingStatus)
                throw IllegalStateException("Binding ${holder.binding} viewModel variable name should be 'viewModel'")
        }
    }

    override fun getItemViewType(position:Int) =getLayoutIdForPosition(position)

    abstract fun getLayoutIdForPosition(position: Int): Int

    abstract fun getViewModel(position: Int): Any?

    abstract  fun clearAllItems()

    abstract  fun addAllItems(items : List<T>)
}