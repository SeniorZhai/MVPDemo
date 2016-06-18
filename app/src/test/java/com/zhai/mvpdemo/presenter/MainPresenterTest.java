package com.zhai.mvpdemo.presenter;

import com.zhai.mvpdemo.model.MainModel;
import com.zhai.mvpdemo.view.MainView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zhai on 16/6/18.
 */
public class MainPresenterTest {
    private MainView view;
    private MainModel model;
    private MainPresenter presenter;

    @Before
    public void setUp() throws Exception {
        model = mock(MainModel.class);
        view = mock(MainView.class);
        presenter = new MainPresenter(view, model);
    }

    @Test
    public void testOnCreat() throws Exception {
        presenter.onCreate();
        verify(view).setContentView();
        verify(view).initButton();
        verify(view).initRecylerView();
    }

    @Test
    public void testOnSavaButtonClick() throws Exception {
        presenter.onSavaButtonClick("111");
        verify(model).addNoteList("111");
        verify(view).clearNoteText();
        verify(view).updateRecylerView(model.getNoteList());
    }

    @Test
    public void testOnDeleteButtonClick() throws Exception {
        presenter.onDeleteButtonClick(0);
        verify(model).removeNoteFromList(0);
        verify(view).updateRecylerView(model.getNoteList());
    }

    @After
    public void tearDown() throws Exception {

    }

}