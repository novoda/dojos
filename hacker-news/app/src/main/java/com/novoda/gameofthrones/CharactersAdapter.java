package com.novoda.gameofthrones;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class CharactersAdapter extends RecyclerView.Adapter {
    private Context context;
    private final List<Character> listOfCharacters;

    CharactersAdapter(Context context, List<Character> listOfCharacters) {
        this.context = context;
        this.listOfCharacters = listOfCharacters;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CharacterView characterView = new CharacterView(context);
        return new GenericViewHolder(characterView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CharacterView itemView = (CharacterView) holder.itemView;
        Character character = listOfCharacters.get(position);
        String characterName = character.getName();
        TextView characterNameView = itemView.getCharacterNameView();
        characterNameView.setText(characterName);
    }

    @Override
    public int getItemCount() {
        return listOfCharacters.size();
    }
}
