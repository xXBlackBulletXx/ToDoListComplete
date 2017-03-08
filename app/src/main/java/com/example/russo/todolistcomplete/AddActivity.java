package com.example.russo.todolistcomplete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText titolo, descrizione, data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titolo = (EditText) findViewById(R.id.add_titolo);
        descrizione = (EditText) findViewById(R.id.add_descrizione);
        data = (EditText) findViewById(R.id.add_date);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_conferma:
                Intent i = new Intent();
                i.putExtra("Titolo", titolo.getText().toString());
                i.putExtra("Descrizione", descrizione.getText().toString());
                i.putExtra("Data", data.getText().toString());
                setResult(Activity.RESULT_OK, i);
                finish();
                break;
            case android.R.id.home:
                finish();
        }
        return true;
    }
}
