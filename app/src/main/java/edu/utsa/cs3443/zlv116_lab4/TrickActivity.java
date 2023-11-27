package edu.utsa.cs3443.zlv116_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.utsa.cs3443.zlv116_lab4.model.Trivia;

public class TrickActivity extends AppCompatActivity implements View.OnClickListener {

    private Trivia trivia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick);

        loadQuestion();
        setupQuestionText();
        setupButtons();
    }

    private void loadQuestion() {
        trivia = new Trivia();
        trivia.loadTrivia(this);
    }

    private void setupQuestionText() {
        TextView questionTextView = findViewById(R.id.questionText);
        questionTextView.setText(trivia.getQuestion());
    }

    private void setupButtons() {
        int[] buttonIDs = {R.id.button1, R.id.button2, R.id.button3};
        String[] buttonText = {trivia.getOption1(), trivia.getOption2(), trivia.getOption3()};
        for (int i = 0; i < buttonIDs.length; i++) {
            Button button = findViewById(buttonIDs[i]);
            button.setText(buttonText[i]);
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        String buttonText = clickedButton.getText().toString();

        // Check if the selected option is the correct answer
        if (buttonText.equals(trivia.getCorrectAnswer())) {
            // Display a toast for correct answer along with the description
            showToast("Correct!\n" + trivia.getDescriptionAnswer());
        } else {
            // Display a toast for incorrect answer along with the description
            showToast("Incorrect!\n" + trivia.getDescriptionAnswer());
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}