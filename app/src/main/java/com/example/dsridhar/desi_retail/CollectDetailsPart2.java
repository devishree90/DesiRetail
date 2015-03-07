package com.example.dsridhar.desi_retail;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;


public class CollectDetailsPart2 extends ActionBarActivity {
    public final static String PROD_DETAILS = "com.example.dsridhar.desi_retail.PROD_DETAILS";

    HashMap<String, String> prod_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        prod_details = (HashMap<String, String>)intent.getSerializableExtra(MainActivity.PROD_DETAILS);
        Log.v("HashMapTest", prod_details.values().toString());
        setContentView(R.layout.activity_collect_details_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void sendStock(View view) {
        Intent intent = new Intent(this, CollectDetailsPart3.class);
        prod_details.put("stock",((EditText)findViewById(R.id.stock)).getText().toString());
        intent.putExtra(PROD_DETAILS, prod_details);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
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
}
