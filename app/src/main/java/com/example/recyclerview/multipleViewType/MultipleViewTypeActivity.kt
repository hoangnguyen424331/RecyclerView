package com.example.recyclerview.multipleViewType

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.recyclerview.R
import com.example.recyclerview.multipleViewType.Const.TYPE_FOOTER
import com.example.recyclerview.multipleViewType.Const.TYPE_HEADER
import com.example.recyclerview.multipleViewType.Const.TYPE_ITEM
import com.example.recyclerview.multipleViewType.adapter.MultipleViewTypeAdapter
import com.example.recyclerview.multipleViewType.model.FooterInfo
import com.example.recyclerview.multipleViewType.model.HeaderInfo
import com.example.recyclerview.multipleViewType.model.User
import com.example.recyclerview.multipleViewType.model.UserInfo
import kotlinx.android.synthetic.main.activity_multiple_view_type.*

class MultipleViewTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_view_type)

        val headerInfo = HeaderInfo("Header item 1", "Header item 2", "Header item 3")
        val userInfo = UserInfo(
            User("nguyen", R.drawable.ic_baseline_face_24),
            User("phuong", R.drawable.ic_baseline_face_24),
            User("abc", R.drawable.ic_baseline_face_24)
        )
        val footerInfo = FooterInfo(
            "Footer item 1",
            "Footer item 2",
            "Footer item 3"
        )

        val items = mutableListOf<ItemViewHolder<Any>>(
            ItemViewHolder(headerInfo, TYPE_HEADER),
            ItemViewHolder(userInfo, TYPE_ITEM),
            ItemViewHolder(footerInfo, TYPE_FOOTER)
        )
        val multipleViewTypeAdapter = MultipleViewTypeAdapter(this)
        multipleViewTypeAdapter.setData(items)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerViewMultipleView.apply {
            adapter = multipleViewTypeAdapter
            addItemDecoration(itemDecoration)
        }
    }
}
