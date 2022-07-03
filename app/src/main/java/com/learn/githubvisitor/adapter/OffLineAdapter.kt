package com.learn.githubvisitor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Item
import com.learn.githubvisitor.databinding.RepoItemListBinding
import com.learn.githubvisitor.model.GitHubDB
import com.learn.githubvisitor.utils.OffSendData
import com.learn.githubvisitor.utils.SendData
import javax.inject.Inject

class OffLineAdapter @Inject constructor() : RecyclerView.Adapter<TaskViewReportHolderOffLine>() {
    lateinit var offCLickData: OffSendData
    var repoList = mutableListOf<GitHubDB>()
    fun sendOffline(reports: List<GitHubDB>, offClick: OffSendData) {
        this.repoList = reports.toMutableList()
        offCLickData=offClick
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewReportHolderOffLine {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepoItemListBinding.inflate(inflater, parent, false)
        return TaskViewReportHolderOffLine(binding)
    }

    override fun onBindViewHolder(holder: TaskViewReportHolderOffLine, position: Int) {
        val reportList = repoList[position]
        holder.binding.apply {
            tvTitleRepository.text=reportList.title
            tvDescription.text=reportList.descritption

        }
        holder.binding.cdRepoITem.setOnClickListener {
            offCLickData.onClickOffLine(reportList)
        }

    }

    override fun getItemCount(): Int {
        return repoList.size
    }




}


class TaskViewReportHolderOffLine(val binding: RepoItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
}