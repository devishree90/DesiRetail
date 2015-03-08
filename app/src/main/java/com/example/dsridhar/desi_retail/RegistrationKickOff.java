package com.example.dsridhar.desi_retail;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lrajanal on 06/03/15.
 */

public class RegistrationKickOff extends ActionBarActivity{

    public static final String EXTRA_MESSAGE = "com.example.helloworldretry.MESSAGE";
    public static final String PREF_NAME ="DesiRetailPrefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        if(prefs.getString("phone_number",null).toString() == null)
        {
            setContentView(R.layout.activity_main);
        }
        else
        {
            setContentView(R.layout.activity_registration_kickoff);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
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
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        EditText product_category_text = (EditText) findViewById(R.id.product_sub_category);
        EditText product_sub_category_text = (EditText)findViewById(R.id.product_category);
        setContentView(R.layout.activity_product_category_details);
        editor.putString("product_category", product_category_text.getText().toString());
        editor.putString("product_sub_category",product_sub_category_text.getText().toString());
        editor.commit();
        setContentView(R.layout.activity_bank_details);
        //startActivity(intent);
    }

    //Run when user clicks next in Bank details page
    public void goToWebChooserPage(View view)
    {
        Intent intent = new Intent(this,WebSiteChooser.class);
        SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit();
        EditText bankName = (EditText) findViewById(R.id.bank_name);
        EditText ifscCode = (EditText)findViewById(R.id.ifsc_code);
        EditText accountNumber = (EditText) findViewById(R.id.account_number);

        editor.putString("bank_name",bankName.getText().toString());
        editor.putString("ifsc_code",ifscCode.getText().toString());
        editor.putString("account_number",accountNumber.getText().toString());
        editor.commit();
        setContentView(R.layout.activity_website_chooser);
    }

    //Run when user clicks done in web site chooser page
    public void goToReviewPage(View view)
    {
        TextView mainTextView;
        Button mainButton;
        CheckBox eCommSite1;
        CheckBox eCommSite2;
        ListView listUserRegistrationDetails;

        ArrayAdapter mArrayAdapter;
        ArrayList mNameList = new ArrayList();
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        eCommSite1 = (CheckBox) findViewById(R.id.eCommSite1CheckBox);
        eCommSite2 = (CheckBox) findViewById(R.id.eCommSite2CheckBox);

        setContentView(R.layout.activity_review);
        listUserRegistrationDetails = (ListView) findViewById(R.id.review_list_view);

        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,mNameList);

        listUserRegistrationDetails.setAdapter(mArrayAdapter);

        //mNameList.add(((EditText)findViewById(R.id.edit_message)).getText().toString());


        mNameList.add("Phone number: "+prefs.getString("phone_number","None"));
        mNameList.add("Product category : "+prefs.getString("product_category","None"));
        mNameList.add("Product sub category: "+prefs.getString("product_sub_category","None"));
        mNameList.add("Bank name : "+prefs.getString("bank_name","None"));
        mNameList.add("IFSC code: "+prefs.getString("ifsc_code","None"));
        mNameList.add("Account number : "+prefs.getString("account_number","None"));

        if(eCommSite1.isChecked())
        {
            mNameList.add("Website selected: "+eCommSite1.getText().toString());
        }
        if(eCommSite2.isChecked())
        {
            mNameList.add("Website selected: "+eCommSite2.getText().toString());
        }

        mArrayAdapter.notifyDataSetChanged();
    }

    //Run when user clicks Go to home button in review page
    public void goToRegisteredHome(View v)
    {
        Intent intent = new Intent(this,Review.class);
        setContentView(R.layout.activity_main);
    }

    //Invoke product registration flow!
    public void prodRegistration(View view)
    {
        Intent intent = new Intent(this, CollectDetailsPart1.class);
        startActivity(intent);
    }

}
