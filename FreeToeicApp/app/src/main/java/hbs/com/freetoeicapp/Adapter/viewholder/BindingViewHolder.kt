package hbs.com.freetoeicapp.Adapter.viewholder

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

class BindingViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: T

    init {
        this.binding = (DataBindingUtil.bind<ViewDataBinding>(itemView) as T?)!!
    }

    fun binding(): T {
        return binding
    }
}
