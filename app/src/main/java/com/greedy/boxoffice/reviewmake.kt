package com.greedy.boxoffice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.greedy.boxoffice.databinding.ActivityReviewmakeBinding

class reviewmake : AppCompatActivity() {

    val binding by lazy { ActivityReviewmakeBinding.inflate(layoutInflater) }
    val helper = SqliteHelper(this, "memo", 1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = RecyclerAdapter()
        adapter.helper = helper
        /* selectMemo를 통해 DB에 있는 메모를 모두 조회해서 List 반환 받고
        * 해당 데이터를 Adapter의 listData에 담는다. */
        adapter.listData.addAll(helper.selectMemo())

        /* main activity의 recyclerView에 생성한 어댑터 연결하고 레이아웃 설정 */
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        /* 메모 저장 버튼 이벤트 */
        binding.saveButton.setOnClickListener {
            /* 메모 내용이 입력 된 경우만 동작 */
            if(binding.editMemo.text.toString().isNotEmpty()) {
                val memo = Memo(null, binding.editMemo.text.toString())
                helper.insertMemo(memo)

                /* DB가 변동 되었을 때 화면도 변동될 수 있도록 adapter의 data를 수정하고
                *  데이터가 변화 했음을 알린다. */
                adapter.listData.clear()
                adapter.listData.addAll(helper.selectMemo())
                adapter.notifyDataSetChanged()

                /* 입력란 비우기 */
                binding.editMemo.setText("")
            }
        }


    }
}