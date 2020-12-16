package com.example.kotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinrecyclerview.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*
import java.util.ArrayList

class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    private var items: List<BlogPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BlogViewHolder -> {
                holder.Bind(items.get(position))
            }

        }    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BlogPost>){
        items = blogList
    }

    class BlogViewHolder constructor (itemView: View): RecyclerView.ViewHolder(itemView){
        val BlogImage = itemView.image_blog
        val BlogTitle = itemView.title_blog
        val AuthorBlog = itemView.author_blog



        fun Bind(blogPost: BlogPost ){
            BlogTitle.setText(blogPost.title)
            AuthorBlog.setText(blogPost.username)


            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .dontAnimate()
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(BlogImage)

        }
    }





}