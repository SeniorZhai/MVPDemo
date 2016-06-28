package com.zhai.mvpdemo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.zhai.mvpdemo.MyApplication
import com.zhai.mvpdemo.R
import com.zhai.mvpdemo.model.MainModel
import com.zhai.mvpdemo.presenter.DaggerMainComponent
import com.zhai.mvpdemo.presenter.MainModule
import com.zhai.mvpdemo.presenter.MainPresenter
import com.zhai.mvpdemo.view.adapter.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named


class MainActivity : AppCompatActivity(), MainView {

    @field:[Inject Named("presenter")]
    lateinit var mPresenter: MainPresenter

    @field:[Inject Named("model")]
    lateinit var mModel: MainModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainComponent.builder().appComponent((application as MyApplication).appComponent).mainModule(MainModule(this)).build().inject(this)
        mPresenter.onCreate()
    }

    override fun initRecylerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NoteAdapter(mModel.noteList, object : NoteAdapter.DeleteButtonListener {
            override fun onDeleteButtonClick(position: Int) {
                mPresenter.onDeleteButtonClick(position)
            }
        })
    }

    override fun setContentView() {
        setContentView(R.layout.activity_main)
    }

    override fun initButton() {
        add!!.setOnClickListener { mPresenter.onSavaButtonClick(edit!!.text.toString()) }
    }

    override fun updateRecylerView(noteList: List<String>) {
        recyclerView.adapter.notifyDataSetChanged()
    }

    override fun clearNoteText() {
        edit.setText("")
    }

}
