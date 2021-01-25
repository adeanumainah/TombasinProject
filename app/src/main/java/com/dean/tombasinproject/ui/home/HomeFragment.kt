package com.dean.tombasinproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.dean.tombasinproject.R
import com.dean.tombasinproject.adapter.TumbasinAdapter
import com.dean.tombasinproject.model.ProductItem
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONArray
import org.json.JSONException

class HomeFragment : Fragment() {

    private lateinit var tumbasinAdapter: TumbasinAdapter
    var productItem: MutableList<ProductItem> = ArrayList()

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
        val carouselView = is_main as CarouselView
        carouselView.setPageCount(imageContentSlider.size)
        carouselView.setImageListener(imageContentListener)

        showRecyclerList()
        getlistProduct()

    }

    private fun showRecyclerList() {
        tumbasinAdapter.notifyDataSetChanged()
        rv_product.setHasFixedSize(true)
        rv_product.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_product.adapter = tumbasinAdapter
    }


    private fun getlistProduct() {
        AndroidNetworking.get(com.dean.tombasinproject.network.Api.URL_LIST_PRODUCT)
            .setPriority(Priority.MEDIUM)
            .build().getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {
                    for (i in 0 until response.length()) {
                        try {
                            val dataApi = ProductItem()
                            val jsonObject = response.getJSONObject(i)
                            dataApi.name = jsonObject.getString("name")
                            dataApi.price = jsonObject.getString("price")
//                            dataApi.images = jsonObject.getInt("images")
                            productItem.add(dataApi)
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            Toast.makeText(getContext(), "Gagal menampilkan data",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(getContext(),"Tidak ada jaringan",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })
    }

    private fun showProduct() {
//        tumbasinAdapter = TumbasinAdapter(HomeFragment::class.java,
//            productItem, this)
        rv_product!!.adapter = tumbasinAdapter
    }
}