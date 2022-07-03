package com.learn.githubvisitor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learn.githubvisitor.databinding.RepoItemListBinding
import com.learn.githubvisitor.model.GithubDetails
import com.learn.githubvisitor.model.Item
import com.learn.githubvisitor.utils.SendData
import javax.inject.Inject

class RepositoryAdapter @Inject constructor() : RecyclerView.Adapter<TaskViewReportHolder>() {
    lateinit var onClickdata: SendData
    var repoList = mutableListOf<Item>()
    fun sendRepositoryList(reports: List<Item>,onClick:SendData) {
        this.repoList = reports.toMutableList()
        onClickdata=onClick
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewReportHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepoItemListBinding.inflate(inflater, parent, false)
        return TaskViewReportHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewReportHolder, position: Int) {
        val reportList = repoList[position]
        holder.binding.apply {
            tvTitleRepository.text=reportList.full_name
            tvDescription.text=reportList.description

        }
        holder.binding.cdRepoITem.setOnClickListener {
            onClickdata.onClick(reportList)
        }

    }

    override fun getItemCount(): Int {
        return repoList.size
    }


}


class TaskViewReportHolder(val binding: RepoItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
}
