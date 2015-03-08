package com.example.dsridhar.desi_retail;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class RegistrationKickOff extends ActionBarActivity{

    public static final String EXTRA_MESSAGE = "com.example.helloworldretry.MESSAGE";
    public static final String PREF_NAME ="DesiRetailPrefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_kickoff);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    /*This method  is invoked when the user clicks send button*/
    public void getRegisteredPhoneNumber(View view)
    {
        //Do something in response to button
        Intent intent = new Intent(this,ProductCategoryDetails.class);
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        EditText editText = (EditText) findViewById(R.id.edit_message);
        setContentView(R.layout.activity_product_category_details);
        editor.putString("phone_number",editText.getText().toString());
        editor.commit();
        //String message = editText.getText().toString();
        //mainTextView = (TextView) findViewById(R.id.product_detail_info_text);
        //mainTextView.setText(EXTRA_MESSAGE);
        //startActivity(intent);
    }

    //Runs when user clicks next in Product details page
    public void goToBankDetails(View view)
    {
        Intent intent = new Intent(this,BankDetails.class);
        setContentView(R.layout.activity_bank_details);
    }

    //Run when user clicks next in Bank details page
    public void goToWebChooserPage(View view)
    {
        Intent intent = new Intent(this,WebSiteChooser.class);
        setContentView(R.layout.activity_website_chooser);
    }

    //Run when user clicks done in web site chooser page
    public void goToReviewPage(View view)
    {
        TextView mainTextView;
        Button mainButton;

        ListView listUserRegistrationDetails;

        ArrayAdapter mArrayAdapter;
        ArrayList mNameList = new ArrayList();
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);


        Intent intent = new Intent(this,Review.class);
        setContentView(R.layout.activity_review);

        listUserRegistrationDetails = (ListView) findViewById(R.id.review_list_view);

        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,mNameList);

        listUserRegistrationDetails.setAdapter(mArrayAdapter);

        //mNameList.add(((EditText)findViewById(R.id.edit_message)).getText().toString());


        mNameList.add("Phone number: "+prefs.getString("phone_number","123"));
        mArrayAdapter.notifyDataSetChanged();
    }

    //Run when user clicks Go to home button in review page
    public void goToRegisteredHome(View v)
    {
        Intent intent = new Intent(this,Review.class);
        setContentView(R.layout.activity_main);
    }

}