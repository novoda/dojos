package com.novoda.gameofthrones;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

class CharacterView extends LinearLayout {

    private TextView characterNameView;

    public CharacterView(Context context) {
        super(context);

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        layoutInflater.inflate(R.layout.character_view_layout, this, true);
        characterNameView = findViewById(R.id.character_name_view);
    }

    public TextView getCharacterNameView() {
        return characterNameView;
    }
}
