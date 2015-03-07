package com.example.dsridhar.desi_retail;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;


public class CollectDetailsPart1 extends ActionBarActivity {
    public final static String PROD_DETAILS = "com.example.dsridhar.desi_retail.PROD_DETAILS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_details_part1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    public void sendMessage(View view) {
        HashMap prod_details=new HashMap();
        Intent intent = new Intent(this, CollectDetailsPart2.class);
        prod_details.put("prod_name",((EditText) findViewById(R.id.productName)).getText().toString());
        prod_details.put("prod_info",((EditText) findViewById(R.id.productInfo)).getText().toString());
        prod_details.put("prod_cost",((EditText) findViewById(R.id.productCost)).getText().toString());
        intent.putExtra(PROD_DETAILS, prod_details);
        startActivity(intent);
    }
}

