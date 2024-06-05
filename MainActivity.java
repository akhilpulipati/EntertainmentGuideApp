package edu.dayton.entertainmentguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare instance variables for the Spinner and Button
    private Spinner browsespinner;
    private Button browsebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the layout for this activity

        // Initialize the Spinner and Button from the layout XML
        browsespinner = findViewById(R.id.moviespinner);
        browsebutton = findViewById(R.id.browsebutton);

        // Create an ArrayAdapter to populate the Spinner with data from the array resource
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Browselist, // The array resource containing the data for the Spinner
                android.R.layout.simple_spinner_item // Layout for each item in the Spinner
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        browsespinner.setAdapter(adapter); // Set the ArrayAdapter as the Spinner's adapter

        // Set a click listener on the Button
        browsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected option index from the Spinner
                int selectedOption = browsespinner.getSelectedItemPosition();
                // Call the method to navigate to the corresponding activity
                navigateToActivity(selectedOption);
            }
        });
    }

    // Method to navigate to the appropriate activity based on the selected option
    private void navigateToActivity(int option) {
        Class<?> targetActivity;
        switch (option) {
            case 0:
                targetActivity = tvshowgenre.class;
                break;
            case 1:
                targetActivity = tvshowlanguage.class;
                break;
            case 2:
                targetActivity = tvshowyear.class;
                break;
            case 3:
                targetActivity = moviegenre.class;
                break;
            case 4:
                targetActivity = movielanguage.class;
                break;
            case 5:
                targetActivity = movieyear.class;
                break;
            default:
                targetActivity = MainActivity.class; // Fallback to MainActivity if option is not recognized
                break;
        }

        // Create an entertainment Intent to navigate to the target activity
        Intent entertainmentintent = new Intent(MainActivity.this, targetActivity);
        startActivity(entertainmentintent); // Start the target activity
    }
}





