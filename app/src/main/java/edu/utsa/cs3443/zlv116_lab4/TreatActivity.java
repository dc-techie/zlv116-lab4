package edu.utsa.cs3443.zlv116_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.security.SecureRandom;

public class TreatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat);

        ImageView treatImageView = findViewById(R.id.treatImage);

        // Array of image resource IDs
        int[] treatImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
                R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8,
                R.drawable.image9};

        // Get a random index
        SecureRandom secureRandom = new SecureRandom();
        int randomIndex = secureRandom.nextInt(treatImages.length);

        // Set the random image to the ImageView
        treatImageView.setImageResource(treatImages[randomIndex]);
    }

}