package com.zhai.mvpdemo.presenter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import com.zhai.mvpdemo.R
import com.zhai.mvpdemo.model.MainModel
import com.zhai.mvpdemo.view.MainView
import com.zhai.mvpdemo.view.adapter.NoteAdapter


class MainActivity : AppCompatActivity(), MainView {

    private var mPresenter: MainPresenter? = null
    private var mModel: MainModel? = null
    private var mRecyclerView: RecyclerView? = null
    private var mEdit: EditText? = null
    private var mAdd: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mModel = MainModel()
        mPresenter = MainPresenter(this, mModel!!)
        mPresenter!!.onCreate()
    }

    override fun initRecylerView() {
        mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mRecyclerView!!.adapter = NoteAdapter(mModel!!.noteList, listener = object : NoteAdapter.DeleteButtonListener {
            override fun onDeleteButtonClick(position: Int) {
                mPresenter!!.onDeleteButtonClick(position)
            }

        })
    }

    override fun setContentView() {
        setContentView(R.layout.activity_main)
    }

    override fun initButton() {
        mAdd = findViewById(R.id.add) as Button
        mEdit = findViewById(R.id.edit) as EditText
        mAdd!!.setOnClickListener { mPresenter!!.onSavaButtonClick(mEdit!!.text.toString()) }
    }

    override fun updateRecylerView(noteList: List<String>) {
        mRecyclerView!!.adapter.notifyDataSetChanged()
    }

    override fun clearNoteText() {
        mEdit!!.setText("")
    }

}
