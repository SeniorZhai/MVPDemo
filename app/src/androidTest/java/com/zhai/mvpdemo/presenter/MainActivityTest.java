package com.zhai.mvpdemo.presenter;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhai.mvpdemo.R;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by zhai on 16/6/18.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void textOnSaveButtonClick() throws Exception {
        enterText("aaa");
        clickSaveButton();
        onView(withId(R.id.recyclerView)).check(hasItem(1));
    }

    @Test
    public void testOnDeleteButtonClick() throws Exception {
        enterText("note");
        clickSaveButton();
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(
                        0, MyViewAction.clickChildViewWithId(R.id.remove)));

        onView(withId(R.id.recyclerView))
                .check(hasItem(0));
    }

    // 自定义判断
    private static ViewAssertion hasItem(final int count) {
        return new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (!(view instanceof RecyclerView)) {
                    throw noViewFoundException;
                }
                RecyclerView rv = (RecyclerView) view;
                Assert.assertEquals(count, rv.getAdapter().getItemCount());
            }
        };
    }

    private void enterText(String text) {
        onView(withId(R.id.edit))
                .perform(typeText(text), closeSoftKeyboard());
    }

    private void clickSaveButton() {
        onView(withId(R.id.add)).perform(click());
    }

    public static class MyViewAction {

        public static ViewAction clickChildViewWithId(final int id) {
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return null;
                }

                @Override
                public String getDescription() {
                    return "Click on a child view with specified id.";
                }

                @Override
                public void perform(UiController uiController, View view) {
                    View v = view.findViewById(id);
                    if (v != null) {
                        v.performClick();
                    }
                }
            };
        }

    }
}