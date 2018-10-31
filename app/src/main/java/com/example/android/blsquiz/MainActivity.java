package com.example.android.blsquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


// App checks basic knowledge about Basic Life Support
public class MainActivity extends AppCompatActivity {

    int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This method represents answers
    private int calculateScore() {

        //Correct answers for:
        //Q1 answer 3
        RadioButton q1a3 = (RadioButton) findViewById(R.id.q1a3);
        boolean q1a3Checked = q1a3.isChecked();

        //Q2 answer 3
        RadioButton q2a3 = (RadioButton) findViewById(R.id.q2a3);
        boolean q2a3Checked = q2a3.isChecked();

        //Q3 answer 2 and 3
        CheckBox q3a2 = (CheckBox) findViewById(R.id.q3a2);
        boolean q3a2Checked = q3a2.isChecked();
        CheckBox q3a3 = (CheckBox) findViewById(R.id.q3a3);
        boolean q3a3Checked = q3a3.isChecked();

        //Q4 answer 1 and 4
        CheckBox q4a1 = (CheckBox) findViewById(R.id.q4a1);
        boolean q4a1Checked = q4a1.isChecked();
        CheckBox q4a4 = (CheckBox) findViewById(R.id.q4a4);
        boolean q4a4Checked = q4a4.isChecked();

        //Q5 answers 3
        RadioButton q5a3 = (RadioButton) findViewById(R.id.q5a3);
        boolean q5a3Checked = q5a3.isChecked();

        //Wrong answers for:
        //Q3 answer 1 and 4
        CheckBox q3a1 = (CheckBox) findViewById(R.id.q3a1);
        boolean q3a1Checked = q3a1.isChecked();
        CheckBox q3a4 = (CheckBox) findViewById(R.id.q3a4);
        boolean q3a4Checked = q3a4.isChecked();

        //Q4 answer 2 and 3
        CheckBox q4a2 = (CheckBox) findViewById(R.id.q4a2);
        boolean q4a2Checked = q4a2.isChecked();
        CheckBox q4a3 = (CheckBox) findViewById(R.id.q4a3);
        boolean q4a3Checked = q4a3.isChecked();

        //Scoring
        if (q1a3Checked) {
            finalScore += 1;
        }

        if (q2a3Checked) {
            finalScore += 1;
        }

        //Check wrong answers are not checked
        if (!(q3a1Checked || q3a4Checked)) {

            if (q3a2Checked && q3a3Checked) {
                finalScore += 1;
            }
        }

        //Check wrong answers are not checked
        if (!(q4a2Checked || q4a3Checked)) {

            if (q4a1Checked && q4a4Checked) {
                finalScore += 1;
            }
        }

        if (q5a3Checked) {
            finalScore += 1;
        }

        EditText correctAnswer = (EditText) findViewById(R.id.enter_your_answer);
        if (correctAnswer.getText().toString().equals("ten") || correctAnswer.getText().toString().equals("TEN") || correctAnswer.getText().toString().equals("10") || correctAnswer.getText().toString().equals("Ten")) {
            finalScore += 1;
        } else {
            finalScore += 0;
        }

        return finalScore;
    }

    //Method to  calculate final score
    public void seeScore(View view) {
        finalScore = calculateScore();
        display(finalScore);
    }

    //Toast message to display after pushing button Result
    private void display(int score) {

        //Get user name from the EditText field
        EditText nameText = findViewById(R.id.enter_your_name);
        Editable name = nameText.getText();

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        String text = name + " your score is " + finalScore + " out of 5!";
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        finalScore = 0;
    }

    //Reset Score
    public void resetScore(View v) {
        finalScore = 0;

        EditText nameText = findViewById(R.id.enter_your_name);
        nameText.setText("");

        EditText correctAnswer = (EditText) findViewById(R.id.enter_your_answer);
        correctAnswer.setText("");

        //Uncheck answers in RadioGroups
        RadioGroup radioGroup1 = findViewById(R.id.radio_group_q1);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = findViewById(R.id.radio_group_q2);
        radioGroup2.clearCheck();

        RadioGroup radioGroup5 = findViewById(R.id.radio_group_q5);
        radioGroup5.clearCheck();

        //Unchecks  answers - Checkboxes
        CheckBox checkBox3_1 = findViewById(R.id.q3a1);
        checkBox3_1.setChecked(false);

        CheckBox checkBox3_2 = findViewById(R.id.q3a2);
        checkBox3_2.setChecked(false);

        CheckBox checkBox3_3 = findViewById(R.id.q3a3);
        checkBox3_3.setChecked(false);

        CheckBox checkBox3_4 = findViewById(R.id.q3a4);
        checkBox3_4.setChecked(false);

        CheckBox checkBox4_1 = findViewById(R.id.q4a1);
        checkBox4_1.setChecked(false);

        CheckBox checkBox4_2 = findViewById(R.id.q4a2);
        checkBox4_2.setChecked(false);

        CheckBox checkBox4_3 = findViewById(R.id.q4a3);
        checkBox4_3.setChecked(false);

        CheckBox checkBox4_4 = findViewById(R.id.q4a4);
        checkBox4_4.setChecked(false);
    }
}


