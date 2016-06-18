package com.zhai.mvpdemo.presenter

import com.zhai.mvpdemo.model.MainModel
import com.zhai.mvpdemo.view.MainView

/**
 * Created by zhai on 16/6/18.
 */

class MainPresenter(private val view: MainView, private val model: MainModel) {

    fun onCreate() {
        view.setContentView()
        view.initRecylerView()
        view.initButton()
    }

    fun onSavaButtonClick(note: String) {
        if (note.isEmpty()) {
            return
        }
        model.addNoteList(note)
        view.clearNoteText()
        view.updateRecylerView(model.noteList)
    }

    fun onDeleteButtonClick(position: Int) {
        model.removeNoteFromList(position)
        view.updateRecylerView(model.noteList)
    }
}
