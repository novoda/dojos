package com.novoda.gameofthrones;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

class CharacterView extends LinearLayout {

    private TextView textView;

    public CharacterView(Context context) {
        super(context);

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        layoutInflater.inflate(R.layout.character_view_layout, this, true);
        textView = findViewById(R.id.character_name_view);
    }

    public TextView getTextView() {
        return textView;
    }
}
