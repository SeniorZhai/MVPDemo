package com.zhai.mvpdemo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import com.zhai.mvpdemo.MyApplication
import com.zhai.mvpdemo.R
import com.zhai.mvpdemo.model.MainModel
import com.zhai.mvpdemo.presenter.DaggerMainComponent
import com.zhai.mvpdemo.presenter.MainModule
import com.zhai.mvpdemo.presenter.MainPresenter
import com.zhai.mvpdemo.view.adapter.NoteAdapter
import javax.inject.Inject
import javax.inject.Named


class MainActivity : AppCompatActivity(), MainView {

    private var mRecyclerView: RecyclerView? = null
    private var mEdit: EditText? = null
    private var mAdd: Button? = null

    @field:[Inject Named("presenter")]
    lateinit var mPresenter: MainPresenter

    @field:[Inject Named("model")]
    lateinit var mModel: MainModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainComponent.builder().appComponent((application as MyApplication).appComponent).mainModule(MainModule(this)).build().inject(this)
        mPresenter!!.onCreate()
    }

    override fun initRecylerView() {
        mRecyclerView = findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mRecyclerView!!.adapter = NoteAdapter(mModel!!.noteList, object : NoteAdapter.DeleteButtonListener {
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
