package com.example.franceshughes.tinyapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.content.Intent;

public class DiningOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining_options);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.diningOption) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View view) {
        //Log.v("*****", "You clicked on the button!");
        TextView feedback = (TextView) findViewById(R.id.feedback);
        RadioGroup rg = (RadioGroup) findViewById(R.id.diningOption);

        // Check if a radio button is checked
        // Reference: https://stackoverflow.com/questions/11194515/android-get-value-of-the-selected-radio-button
        if(rg.getCheckedRadioButtonId() != -1) {
            int checkedRadioButtonId = rg.getCheckedRadioButtonId();
            View checkedRadioButtonView = rg.findViewById(checkedRadioButtonId);
            int checkedRadioButtonIndex = rg.indexOfChild(checkedRadioButtonView);
            RadioButton theCheckedRadioButton = (RadioButton) rg.getChildAt(checkedRadioButtonIndex);
          //  feedback.setText("Thanks for voting for " + checkedRadioButtonIndex);(String)theCheckedRadioButton.getText());
            if (checkedRadioButtonIndex == 0) {
                Intent startCarm = new Intent(this, carmFood.class);
                startActivity(startCarm);
            }
            if (checkedRadioButtonIndex == 1) {
                Intent startDew = new Intent(this, Dewick_food.class);
                startActivity(startDew);
            }
        }
        else {
            feedback.setText("Sorry, you did select a dining option. Please choose a dining option");
        }
    }
}
