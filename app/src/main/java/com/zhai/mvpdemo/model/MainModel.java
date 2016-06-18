package com.zhai.mvpdemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhai on 16/6/18.
 */

public class MainModel {

    private List<String> mList;

    public MainModel() {
        mList = new ArrayList<>();
    }

    public void addNoteList(String note) {
        mList.add(note);
    }

    public List<String> getNoteList() {
        return mList;
    }

    public void removeNoteFromList(int position) {
        mList.remove(position);
    }
}
