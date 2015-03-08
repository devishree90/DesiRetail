package com.example.dsridhar.desi_retail;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {
    public final static String PROD_DETAILS = "com.example.dsridhar.desi_retail.PROD_DETAILS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
//                openSearch();
                return true;
            case R.id.action_settings:
//                openSettings();
                return true;
            case R.id.action_home:
                openHome();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openHome(){
        Intent intent = new Intent(this, CollectDetailsPart2.class);
        startActivity(intent);
        setContentView(R.layout.activity_collect_details_2);
    }
}
