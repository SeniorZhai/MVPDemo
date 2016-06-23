package com.zhai.mvpdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhai.mvpdemo.MyApplication;
import com.zhai.mvpdemo.R;
import com.zhai.mvpdemo.model.MainModel;
import com.zhai.mvpdemo.presenter.DaggerMainComponent;
import com.zhai.mvpdemo.presenter.MainModule;
import com.zhai.mvpdemo.presenter.MainPresenter;
import com.zhai.mvpdemo.view.adapter.NoteAdapter;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRecyclerView;
    private EditText mEdit;
    private Button mAdd;

    @Inject
    MainPresenter mPresenter;

    @Inject
    MainModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainComponent
                .builder()
                .appComponent(((MyApplication) getApplication()).getAppComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
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
