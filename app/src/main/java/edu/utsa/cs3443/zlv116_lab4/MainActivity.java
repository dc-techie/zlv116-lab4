package edu.utsa.cs3443.zlv116_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtons();
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        String buttonText = clickedButton.getText().toString().toLowerCase();
        if (buttonText.equalsIgnoreCase("treat")) {
            Intent treatIntent = new Intent(MainActivity.this, TreatActivity.class);
            startActivity(treatIntent);
        } else if (buttonText.equalsIgnoreCase("trick")) {
            Intent trickIntent = new Intent(MainActivity.this, TrickActivity.class);
            startActivity(trickIntent);
        }
    }

    private void setupButtons() {
       // two buttons with an id that is an integer
       int[] buttonIDs = {R.id.button1, R.id.button2};
       String[] buttonText = {"Trick", "Treat"};
       for (int i = 0; i < buttonIDs.length; i++) {
           Button button = findViewById(buttonIDs[i]);
           button.setText(buttonText[i]);
           button.setOnClickListener(this);
       }
    }
}