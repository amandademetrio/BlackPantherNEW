package com.example.demetrio.blackpanther;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initialing user's score for the quiz
    int score = 0;
    //Starting quantity on counter for 3rd question
    int boxOfficeQuantity = 205;

    //Initial method, setting up direct link to xml layout*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Final submission method: used to check all answers and calculate the total score
     */

    public void finalSubmitButton(View view) {

        //Checking first answer

        RadioButton answerD = (RadioButton) findViewById(R.id.answerD);

        if (answerD.isChecked()) {
            score = score + 1;
        }

        //Checking second answer
        //Getting checkbox views
        CheckBox avengersCheckbox = (CheckBox) findViewById(R.id.avengers_checkbox);
        CheckBox fantasticFourCheckbox = (CheckBox) findViewById(R.id.fantastic_four_checkbox);
        CheckBox illuminatiCheckbox = (CheckBox) findViewById(R.id.illuminati_checkbox);
        CheckBox xMenCheckBox = (CheckBox) findViewById(R.id.x_men_checkbox);

        //Creating a boolean with the status of the checkbox
        boolean avengers = avengersCheckbox.isChecked();
        boolean fantasticFour = fantasticFourCheckbox.isChecked();
        boolean illuminati = illuminatiCheckbox.isChecked();
        boolean xmen = xMenCheckBox.isChecked();

        if (xmen) {
            //Leaving this empty to act as a "break" and get out of the if statement
        }
        else if (avengers && fantasticFour && illuminati) {
            score = score + 1;
        }

        //Checking third question
        if (boxOfficeQuantity == 202) {
            score = score + 1;
        }

        //Checking 4th question
        EditText pantherSisterView = (EditText) findViewById(R.id.blackpanthersister);
        String pantherSister = pantherSisterView.getText().toString();
        boolean pantherSisterstatus = pantherSister.equalsIgnoreCase("Shuri");

        if (pantherSisterstatus) {
            score = score + 1;
            Toast.makeText(this, "Your final score is " + score, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Your final score is " + score, Toast.LENGTH_SHORT).show();

        }

        //Reseting score to zero after user was informed of their score
        score = 0;

    }

    /**
     * These are the methods used in the counter for question 3
     */

    /**
     * Method used to display a quantity in the 3rd question counter
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Method used to add a million dollars in the 3rd question counter. It stops when it reaches 210
     */
    public void increment(View view) {

        if (boxOfficeQuantity < 210) {
            boxOfficeQuantity = boxOfficeQuantity + 1;
            displayQuantity(boxOfficeQuantity);

        } else {
            Toast toast = Toast.makeText(this, "Tip: It's less than 210 million!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    /**
     * Method used to remove a million dollars in the 3rd question counter. It stops when it reaches 200
     */
    public void decrement(View view) {

        if (boxOfficeQuantity > 200) {
            boxOfficeQuantity = boxOfficeQuantity - 1;
            displayQuantity(boxOfficeQuantity);
        } else {
            Toast toast = Toast.makeText(this, "Tip: It's more than 200 million!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}