package edu.dayton.entertainmentguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class selectedentertainment extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectedentertainment);

        // Retrieve the item's information from the intent
        Intent intent = getIntent();
        if (intent != null) {
            // Extract data from the intent
            String itemName = intent.getStringExtra("itemName");
            String imageName = intent.getStringExtra("imageName");
            String content = intent.getStringExtra("content");
            final String link = intent.getStringExtra("link");

            // Check for null values before setting data
            if (itemName != null && imageName != null && content != null && link != null) {
                // Set the item's information in the layout
                TextView itemNameTextView = findViewById(R.id.entertainmentTitle);
                ImageView itemImageView = findViewById(R.id.entertainmentImage);
                TextView contentTextView = findViewById(R.id.entertainmentInfo);
                Button linkButton = findViewById(R.id.linkButton);

                // Set the movie's name
                itemNameTextView.setText(itemName);

                // Set the appropriate image based on the imageName
                int imageResource = getResources().getIdentifier(imageName, "drawable", getPackageName());
                itemImageView.setImageResource(imageResource);

                // Set the movie's description
                contentTextView.setText(content);

                // Set click listener for the link button
                linkButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Open the link in a web browser when the button is clicked
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                        startActivity(browserIntent);
                    }
                });
            } else {
                // Handle missing data or null values
                Toast.makeText(this, "Error: Missing or invalid data.", Toast.LENGTH_SHORT).show();

                // Close the activity since required data is not available
                finish();
            }
        } else {
            // Handle null intent
            Toast.makeText(this, "Error: Intent is null.", Toast.LENGTH_SHORT).show();

            // Close the activity since intent is null
            finish();
        }
    }
}


