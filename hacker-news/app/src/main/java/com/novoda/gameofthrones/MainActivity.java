package com.novoda.gameofthrones;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("orange");
        strings.add("pear");
        strings.add("nectarine");
        strings.add("peach");
        strings.add("cherry");

        RecyclerView storiesView = (RecyclerView) findViewById(R.id.stories_view);
        storiesView.setLayoutManager(new LinearLayoutManager(this));

        storiesView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                CustomTextView customTextView = new CustomTextView(MainActivity.this);
                return new RecyclerView.ViewHolder(customTextView) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                CustomTextView itemView = (CustomTextView) holder.itemView;
                String string = strings.get(position);
                itemView.getTextView().setText(string);
            }

            @Override
            public int getItemCount() {
                return strings.size();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    static class CustomTextView extends LinearLayout {

        private TextView textView;

        public CustomTextView(Context context) {
            super(context);

            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            layoutInflater.inflate(R.layout.item_view, this, true);
            textView = findViewById(R.id.item_text);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
