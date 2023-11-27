package edu.utsa.cs3443.zlv116_lab4.model;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trivia {
    private String question;
    private String option1;
    private String option2;
    private String option3;

    private String descriptionAnswer;
    private String correctAnswer;

    public Trivia(String question, String option1, String option2, String option3, String descriptionAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.descriptionAnswer = descriptionAnswer;
    }

    public Trivia() {
        Log.d("Trivia", "Explicit default constructor");
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setDescriptionAnswer(String descriptionAnswer) {
        this.descriptionAnswer = descriptionAnswer;
    }

    public String getQuestion() {
        return this.question;
    }
    public String getOption1() {
        return this.option1;
    }

    public String getOption2() {
        return this.option2;
    }
    public String getOption3() {
        return this.option3;
    }
    public String getDescriptionAnswer() {
        return this.descriptionAnswer;
    }
    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    // loadTrivia will take in the activity as an input argument, reads the file and stores
    // one piece of data
    public void loadTrivia(Activity activity) {
        AssetManager manager = activity.getAssets();
        Scanner scanner = null;
        try {
            InputStream input = manager.open("trivia.csv");
            scanner = new Scanner(input);

            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            // Generate a random line number
            SecureRandom sRandom = new SecureRandom();
            int lineNumber = sRandom.nextInt(lines.size());

            // Read the random line
            String line = lines.get(lineNumber);
            String[] lineSplit = line.trim().split(",");

            if (lineSplit.length >= 5) { // checking for incorrect lines
                this.question = lineSplit[0];
                this.option1 = lineSplit[1];
                this.option2 = lineSplit[2];
                this.option3 = lineSplit[3];
                this.descriptionAnswer = lineSplit[4];
                for(int k = 5; k < lineSplit.length; k++) {
                    this.descriptionAnswer = (this.descriptionAnswer + "," + lineSplit[k]);
                }

                identifyCorrectAnswer();
            }

        } catch(FileNotFoundException e) {
            Log.d("FileException", "File not found");
        } catch (IOException e) {
            Log.d("Exception", "IO Exception");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }

    private void identifyCorrectAnswer() {
        // takes each option and checks if description contains any of the options. if so, that
        // option is the correctAnswer
        if (this.descriptionAnswer.contains(this.option1)) {
            this.correctAnswer = this.option1;
        } else if (this.descriptionAnswer.contains(this.option2)) {
            this.correctAnswer = this.option2;
        } else {
            this.correctAnswer = this.option3;
        }
    }
}
