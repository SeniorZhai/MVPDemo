package com.zhai.mvpdemo.model

import java.util.*

/**
 * Created by zhai on 16/6/18.
 */

class MainModel {

    private val mList: MutableList<String>

    init {
        mList = ArrayList<String>()
    }

    fun addNoteList(note: String) {
        mList.add(note)
    }

    val noteList: List<String>
        get() = mList

    fun removeNoteFromList(position: Int) {
        mList.removeAt(position)
    }
}
