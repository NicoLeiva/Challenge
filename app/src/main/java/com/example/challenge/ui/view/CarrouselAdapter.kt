package com.example.challenge.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.challenge.R
import com.example.challenge.model.Image
import com.squareup.picasso.Picasso

class CarrouselAdapter(
    val images: List<Image>,
    var ctx:Context) : PagerAdapter() {


    lateinit var layoutInflater: LayoutInflater

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(ctx)
        var view: View = layoutInflater.inflate(R.layout.image_item,container,false)
        val img:ImageView = view.findViewById(R.id.imageView)
        Picasso.get()
            .load(images[position].thumbnailUrl)
            .into(img)
        container.addView(view,0)
        return view
    }
}
