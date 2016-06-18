package com.zhai.mvpdemo.presenter;

import com.zhai.mvpdemo.model.MainModel;
import com.zhai.mvpdemo.view.MainView;

/**
 * Created by zhai on 16/6/18.
 */

public class MainPresenter {
    private final MainView view;
    private final MainModel model;

    public MainPresenter(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    public void onCreate() {
        view.setContentView();
        view.initRecylerView();
        view.initButton();
    }

    public void onSavaButtonClick(String note) {
        if (note.isEmpty()) {
            return;
        }
        model.addNoteList(note);
        view.clearNoteText();
        view.updateRecylerView(model.getNoteList());
    }

    public void onDeleteButtonClick(int position) {
        model.removeNoteFromList(position);
        view.updateRecylerView(model.getNoteList());
    }
}
