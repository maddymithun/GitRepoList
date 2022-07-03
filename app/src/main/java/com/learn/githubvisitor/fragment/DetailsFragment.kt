package com.learn.githubvisitor.fragment

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.example.Item
import com.learn.githubvisitor.databinding.FragmentDetailsBinding
import com.walton.eapp.base.BaseFragmentWithBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment @Inject constructor() :
    BaseFragmentWithBinding<FragmentDetailsBinding>(FragmentDetailsBinding::inflate)  {
    private var ownderDetails: Item? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadingVm().updateToolbar("Github Rpository Detail")
        if (requireArguments().containsKey("detailsowner")) {
            ownderDetails= arguments?.getParcelable<Item>("detailsowner")
            Glide.with(this)
                .load(ownderDetails!!.owner!!.avatarUrl)
                .into(binding.profileImage)
            binding.tvName.text= ownderDetails!!.owner!!.login
            binding.tvLastUpdateDate.text= ownderDetails!!.updatedAt?.let { dateConverter(it) }
            binding.tvRepoDescription.text= ownderDetails!!.description
        }
    }
    fun dateConverter(date:String):String{
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val outputFormat = SimpleDateFormat("yy-MM-dd hh:ss")
        val parsedDate: Date = inputFormat.parse(date)
        val formattedDate: String = outputFormat.format(parsedDate)
        return formattedDate
    }

}