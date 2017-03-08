package com.example.russo.todolistcomplete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    LinearLayoutManager lm;
    ItemsAdapter adapter;
    ArrayList<Item> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.app_name);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, 100);
            }
        });

        adapter = new ItemsAdapter(arrayList);
        lm = new LinearLayoutManager(this);

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        registerForContextMenu(rv);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==100 && resultCode== Activity.RESULT_OK){
            adapter.add(new Item(data.getStringExtra("Titolo"), data.getStringExtra("Descrizione"), data.getStringExtra("Data"), false));
        }
    }
}
