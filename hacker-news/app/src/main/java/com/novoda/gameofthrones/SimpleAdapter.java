package com.novoda.gameofthrones;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

class SimpleAdapter extends RecyclerView.Adapter {
    private MainActivity mainActivity;
    private final List<Character> listOfCharacters;

    public SimpleAdapter(MainActivity mainActivity, List<Character> listOfCharacters) {
        this.mainActivity = mainActivity;
        this.listOfCharacters = listOfCharacters;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CharacterView characterView = new CharacterView(mainActivity);
        return new RecyclerView.ViewHolder(characterView) {
        };
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CharacterView itemView = (CharacterView) holder.itemView;
        Character character = listOfCharacters.get(position);
        itemView.getTextView().setText(character.getName());
    }

    @Override
    public int getItemCount() {
        return listOfCharacters.size();
    }
}
