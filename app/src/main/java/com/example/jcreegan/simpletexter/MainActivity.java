package com.example.jcreegan.simpletexter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    public String receiver = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickMatt(View v){

        receiver = "Matt";
        Intent i = new Intent(this, ResultsActivity.class);
        i.putExtra("receiver", receiver);
        startActivity(i);
    }
    public void onClickBrian(View v){

        receiver = "Brian";
        Intent i = new Intent(this, ResultsActivity.class);
        i.putExtra("receiver", receiver);
        startActivity(i);
    }
    public void onClickMary(View v){

        receiver = "Mary";
        Intent i = new Intent(this, ResultsActivity.class);
        i.putExtra("receiver", receiver);
        startActivity(i);
    }

}
