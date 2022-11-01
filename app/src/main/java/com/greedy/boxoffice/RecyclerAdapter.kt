package com.greedy.boxoffice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greedy.boxoffice.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder> () {

    var listData = mutableListOf<Memo>()
    var helper:SqliteHelper? = null

    inner class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {

        /* 하나의 Recycler View Holder에는 하나의 Memo Data가 존재 */
        var mMemo: Memo? = null

        /* 삭제 버튼 클릭 시 발생 이벤트 */
        init {
            binding.deleteButton.setOnClickListener {
                helper?.deleteMemo(mMemo!!)
                listData.remove(mMemo)
                notifyDataSetChanged()
            }
        }

        fun setMemo(memo: Memo) {
            binding.textNo.text = "${memo.no}"
            binding.textContent.text = memo.content

            mMemo = memo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData[position]
        holder.setMemo(memo)
    }
}
