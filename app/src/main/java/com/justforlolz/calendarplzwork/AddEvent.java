package com.justforlolz.calendarplzwork;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Calendar;


public class AddEvent extends ActionBarActivity {

    ArrayAdapter<CharSequence> adapter;
    Spinner spinnerMonth, spinnerYear, spinnerDay, spinnerHour, spinnerMinute;
    SharedPreferences prefs;
    EditText titleBox;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);


        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setBuiltInZoomControls(true);
        String data = "<body>" + "<img src=\"banner.png\"/></body>";

        webView.loadDataWithBaseURL("file:///android_asset/",data , "text/html", "utf-8",null);


        titleBox = (EditText) findViewById(R.id.editText);

        spinnerMonth = (Spinner) findViewById(R.id.spinnerMonth);
        adapter = ArrayAdapter.createFromResource(this, R.array.months_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapter);
        //spinnerMonth.getSelectedItemPosition()

        spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        adapter = ArrayAdapter.createFromResource(this, R.array.years_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapter);

        spinnerDay = (Spinner) findViewById(R.id.spinnerDay);
        adapter = ArrayAdapter.createFromResource(this, R.array.days_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapter);


        spinnerHour = (Spinner) findViewById(R.id.spinnerHour);
        adapter = ArrayAdapter.createFromResource(this, R.array.hours_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHour.setAdapter(adapter);

        spinnerMinute = (Spinner) findViewById(R.id.spinnerMinute);
        adapter = ArrayAdapter.createFromResource(this, R.array.minutes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMinute.setAdapter(adapter);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

    }

    public void addButtonClick(View view)
    {
        int month = spinnerMonth.getSelectedItemPosition();
        int year = spinnerYear.getSelectedItemPosition() + 2014;
        int day = spinnerDay.getSelectedItemPosition()+1;
        int hour = spinnerHour.getSelectedItemPosition();
        int minute = spinnerMinute.getSelectedItemPosition();
        String title = titleBox.getText().toString();
        if (title.equalsIgnoreCase("")) title = "event";

        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText("month: " + month + "\nyear: " + year + "\nhour: " + hour + "\nminute: " + minute + "\n" + title);

        if (prefs.getString("Num","").equalsIgnoreCase(""))
        {
            editor.putString("Num", "0");
            editor.apply();
        }

        editor.putString(prefs.getString("Num", ""), "" + year + " " + month + " " + day + " " + hour + " " + minute+ " " + title);

        int place = Integer.parseInt(prefs.getString("Num", ""));

        editor.putString("Num", "" + (place+1));
        editor.apply();

        String fullPref = prefs.getString("0","");
        String[] split = fullPref.split(" ");
        // public final void set (int year, int month, int day, int hourOfDay, int minute)
        Calendar startTime = Calendar.getInstance();
        //TextView show = (TextView) findViewById(R.id.textView5);
        //show.setText(title + " " + Integer.parseInt(split[0]) + " " + Integer.parseInt(split[1]) + " " + Integer.parseInt(split[2]) +
          //        " " + Integer.parseInt(split[3]) + " " + Integer.parseInt(split[4]));
        //show.setText(prefs.getString("Num", "nope") + "   " + prefs.getString("31", "nah"));


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
