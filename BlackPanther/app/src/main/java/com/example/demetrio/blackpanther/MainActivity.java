package com.example.demetrio.blackpanther;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //User's score for the quiz
    int score = 0;
    //Starting quantity on counter for 3rd question
    int boxOfficeQuantity = 205;

    //Initial method, setting up direct link to xml layout*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*Checks Radio Buttons answers and gives user toast message with current score*/
    public void radioQuestion(View view) {
        switch (view.getId()) {
            case R.id.answerA:
                if (true)
                    score = 0;
                Toast.makeText(this, "Your current score is " + score, Toast.LENGTH_SHORT).show();
                break;

            case R.id.answerB:
                if (true)
                    score = 0;
                Toast.makeText(this, "Your current score is " + score, Toast.LENGTH_SHORT).show();
                break;

            case R.id.answerC:
                if (true)
                    score = 0;
                Toast.makeText(this, "Your current score is " + score, Toast.LENGTH_SHORT).show();
                break;

            case R.id.answerD:
                if (true)
                    score = score + 1;
                Toast.makeText(this, "Yay! You got it! Your current score is " + score, Toast.LENGTH_SHORT).show();
                break;

        }
    }

    //Triggered when people click on the Submit button after selecting the boxes
    public void checkingBoxes(View view) {
        //Getting checkbox views
        CheckBox avengersCheckbox = (CheckBox) findViewById(R.id.avengers_checkbox);
        CheckBox fantasticFourCheckbox = (CheckBox) findViewById(R.id.fantastic_four_checkbox);
        CheckBox illuminatiCheckbox = (CheckBox) findViewById(R.id.illuminati_checkbox);

        //Creating a boolean with the status of the checkbox
        boolean avengers = avengersCheckbox.isChecked();
        boolean fantasticFour = fantasticFourCheckbox.isChecked();
        boolean illuminati = illuminatiCheckbox.isChecked();

        if (avengers && fantasticFour && illuminati) {
            score = score + 1;
            Toast.makeText(this, "You got it! Your new score is " + score, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Your current score is still " + score, Toast.LENGTH_SHORT).show();

        }

    }

    /*Counter methods for third question*/

    //Third question counter: Method used to display quantity on 3rd question counter
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    //Third question counter: This method adds one million dollars. It stops when it reaches 210
    public void increment(View view) {
        boxOfficeQuantity = boxOfficeQuantity + 1;

        if (boxOfficeQuantity <= 210) {
            displayQuantity(boxOfficeQuantity);

        } else {
            Toast toast = Toast.makeText(this, "Tip: It's less than 210 million!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    //Third question counter: This method removes one million dollars. It stops when it reaches 200
    public void decrement(View view) {
        boxOfficeQuantity = boxOfficeQuantity - 1;

        if (boxOfficeQuantity >= 200) {
            displayQuantity(boxOfficeQuantity);
        } else {
            Toast toast = Toast.makeText(this, "Tip: It's more than 200 million!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //Checks boxOfficeQuantity number against the correct one and gives out updated score
    public void checkingBoxOffice(View view) {
        if (boxOfficeQuantity == 202) {
            score = score + 1;
            Toast.makeText(this, "You got it again! Your new score is " + score, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Your current score is still " + score, Toast.LENGTH_SHORT).show();
        }
    }

    //Checks if sister name is correct and returns final answer
    public void isNameRight(View view) {

        EditText pantherSisterView = (EditText) findViewById(R.id.blackpanthersister);
        String pantherSister = pantherSisterView.getText().toString();
        boolean pantherSisterstatus = pantherSister.equals("Shuri");

        if (pantherSisterstatus) {
            score = score + 1;
            Toast.makeText(this, "Victory is sweet! Your final score is " + score, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You missed this last one, but don't worry! Your final score is " + score, Toast.LENGTH_SHORT).show();

        }

    }

}
