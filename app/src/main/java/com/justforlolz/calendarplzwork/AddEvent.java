package com.justforlolz.calendarplzwork;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;


public class AddEvent extends ActionBarActivity {

    ArrayAdapter<CharSequence> adapter;
    Spinner spinnerMonth, spinnerYear, spinnerHour, spinnerMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);


        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setBuiltInZoomControls(true);
        String data = "<body>" + "<img src=\"banner.png\"/></body>";

        webView.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);




        spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        adapter = ArrayAdapter.createFromResource(this, R.array.months_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapter);
        //spinnerMonth.getSelectedItemPosition()

        spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        adapter = ArrayAdapter.createFromResource(this, R.array.years_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapter);


        spinnerHour = (Spinner) findViewById(R.id.spinnerHour);
        adapter = ArrayAdapter.createFromResource(this, R.array.hours_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHour.setAdapter(adapter);

        spinnerMinute = (Spinner) findViewById(R.id.spinnerMinute);
        adapter = ArrayAdapter.createFromResource(this, R.array.minutes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinute.setAdapter(adapter);



    }

    public void addButtonClick(View view)
    {
        int month = spinnerMonth.getSelectedItemPosition();
        int year = spinnerYear.getSelectedItemPosition();
        int hour = spinnerHour.getSelectedItemPosition();
        int minute = spinnerMinute.getSelectedItemPosition();

        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText("month: " + month + "\nyear: " + year + "\nhour: " + hour + "\nminute: " + minute);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_event, menu);
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
}
