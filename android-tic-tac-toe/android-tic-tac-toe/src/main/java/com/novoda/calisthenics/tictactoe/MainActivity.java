package com.novoda.calisthenics.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    List<View> views = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup group = (ViewGroup) findViewById(R.id.root);
        for (int i = 0; i < group.getChildCount(); i++) {
            views.add(group.getChildAt(i));
        }

        throw new Error("Leave the UI implementation for later!");
    }
}
