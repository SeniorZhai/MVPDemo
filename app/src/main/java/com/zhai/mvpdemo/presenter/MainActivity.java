package com.zhai.mvpdemo.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhai.mvpdemo.R;
import com.zhai.mvpdemo.model.MainModel;
import com.zhai.mvpdemo.view.MainView;
import com.zhai.mvpdemo.view.adapter.NoteAdapter;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mPresenter;
    private MainModel mModel;
    private RecyclerView mRecyclerView;
    private EditText mEdit;
    private Button mAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModel = new MainModel();
        mPresenter = new MainPresenter(this, mModel);
        mPresenter.onCreate();
    }

    @Override
    public void initRecylerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new NoteAdapter(mModel.getNoteList(), new NoteAdapter.DeleteButtonListener() {
            @Override
            public void onDeleteButtonClick(int position) {
                mPresenter.onDeleteButtonClick(position);
            }
        }));
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initButton() {
        mAdd = (Button) findViewById(R.id.add);
        mEdit = (EditText) findViewById(R.id.edit);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onSavaButtonClick(mEdit.getText().toString());
            }
        });
    }

    @Override
    public void updateRecylerView(List<String> noteList) {
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void clearNoteText() {
        mEdit.setText("");
    }

}
