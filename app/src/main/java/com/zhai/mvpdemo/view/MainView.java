package com.zhai.mvpdemo.view;

import java.util.List;

/**
 * Created by zhai on 16/6/18.
 */

public interface MainView {

    void initRecylerView();

    void setContentView();

    void updateRecylerView(List<String> noteList);

    void clearNoteText();

    void initButton();
}
