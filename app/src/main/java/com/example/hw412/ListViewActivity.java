package com.example.hw412;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);
        BaseAdapter listContentAdapter = createAdapter();

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter() {
        int[] to = {R.id.text, R.id.textLength, R.id.textImage};
        String[] from = {"text", "length", "icon"};
        return new SimpleAdapter(this, prepareContent(), R.layout.list_item, from, to);
    }

    @NonNull
    private List<HashMap<String, Object>> prepareContent() {
        Random rnd = new Random();
        List<HashMap<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map;
        String[] stringArray = getString(R.string.large_text).split("\n\n");
        int[] icons = {R.mipmap.bbicon_foreground, R.drawable.i1, R.drawable.i2,
                R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6,
                R.drawable.i7, R.drawable.i8,};
        for (String s : stringArray) {
            map = new HashMap<>();
            map.put("text", s);
            map.put("length", s.length() + "");
            map.put("icon", icons[rnd.nextInt(icons.length)]);
            list.add(map);
        }
        return list;
    }
}
