package com.dean.tombasinproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dean.tombasinproject.R
import com.dean.tombasinproject.adapter.TumbasinAdapter
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class HomeFragment : Fragment() {

    private lateinit var tumbasinAdapter: TumbasinAdapter

    companion object{
        fun defaultFragment(): HomeFragment{
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    val imageContentSlider = intArrayOf(
        R.drawable.slide1,
        R.drawable.slide2,
        R.drawable.slide3,
        R.drawable.slide4,
    )

    val imageContentListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(imageContentSlider[position])
            //picasso
            Picasso.get().load(imageContentSlider[position]).into(imageView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = R.id.is_main as CarouselView;
        carouselView.setPageCount(imageContentSlider.size)
        carouselView.setImageListener(imageContentListener)
    }
}