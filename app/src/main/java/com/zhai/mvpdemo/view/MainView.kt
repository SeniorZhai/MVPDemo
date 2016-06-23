package com.zhai.mvpdemo.view

/**
 * Created by zhai on 16/6/18.
 */

interface MainView {

    fun initRecylerView()

    fun setContentView()

    fun updateRecylerView(noteList: List<String>)

    fun clearNoteText()

    fun initButton()
}
