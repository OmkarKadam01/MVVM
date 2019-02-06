package com.mvvm.ui.landing.adapter

import com.mvvm.BR
import com.mvvm.R
import com.mvvm.ui.base.RecyclerBaseAdapter
import com.mvvm.ui.base.RecyclerViewHolder
import com.mvvm.ui.landing.pojo.Standings

class LandingAdapter (private val listOfStandings: MutableList<Standings>) : RecyclerBaseAdapter<Standings>() {
    override fun getLayoutIdForPosition(position: Int): Int = R.layout.standing_child

    override fun getViewModel(position: Int): Any? {
       return listOfStandings[position]
    }

    override fun clearAllItems() {
        listOfStandings.clear()
    }

    override fun addAllItems(items: List<Standings>) {
        listOfStandings.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
    getViewModel(position)?.let {
        val bindingStatus= holder.binding.setVariable(BR.viewModel,it)
        if (!bindingStatus)
            throw IllegalStateException("Binding ${holder.binding} viewModel variable name should be 'viewModel'")
        holder.binding.executePendingBindings()
    }
    }

    override fun getItemCount(): Int = listOfStandings.size

}