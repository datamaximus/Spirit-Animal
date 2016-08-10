package jasonwiram.com.spiritanimal.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Random;

import jasonwiram.com.spiritanimal.R;

public class MainActivity extends AppCompatActivity {

    private String mAnimal = "default";

    private Spinner mSpinner1;
    private Spinner mSpinner2;
    private Spinner mSpinner3;
    private Spinner mSpinner4;
    private Spinner mSpinner5;

    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubmitButton = (Button)findViewById(R.id.submitButton);
        mSpinner1 = (Spinner)findViewById(R.id.spinner);
        mSpinner2 = (Spinner)findViewById(R.id.spinner2);
        mSpinner3 = (Spinner)findViewById(R.id.spinner3);
        mSpinner4 = (Spinner)findViewById(R.id.spinner4);
        mSpinner5 = (Spinner)findViewById(R.id.spinner5);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whichAnimal();
                showAnimal();
            }
        });
    }

    private void whichAnimal() {
        String spinner1Choice = mSpinner1.getSelectedItem().toString();
        String spinner2Choice = mSpinner2.getSelectedItem().toString();
        String spinner3Choice = mSpinner3.getSelectedItem().toString();
        String spinner4Choice = mSpinner4.getSelectedItem().toString();
        String spinner5Choice = mSpinner5.getSelectedItem().toString();

        if((spinner2Choice.equalsIgnoreCase("Agree")
                || spinner2Choice.equalsIgnoreCase("Somewhat Agree"))
                && (spinner3Choice.equalsIgnoreCase("Disagree")
                || spinner3Choice.equalsIgnoreCase("Somewhat Disagree"))) {
            mAnimal = "elephant";
        }
         else if((spinner1Choice.equalsIgnoreCase("Agree")
                || spinner1Choice.equalsIgnoreCase("Somewhat Agree"))
                && (spinner3Choice.equalsIgnoreCase("Agree")
                || spinner3Choice.equalsIgnoreCase("Somewhat Agree"))) {
            mAnimal = "dolphin";
        }
        else if((spinner1Choice.equalsIgnoreCase("Agree")
                || spinner1Choice.equalsIgnoreCase("Somewhat Agree"))
                && (spinner5Choice.equalsIgnoreCase("Agree")
                || spinner5Choice.equalsIgnoreCase("Somewhat Agree"))) {
            mAnimal = "monkey";
        }
        else if((spinner2Choice.equalsIgnoreCase("Agree")
                || spinner2Choice.equalsIgnoreCase("Somewhat Agree"))
                && (spinner4Choice.equalsIgnoreCase("Disagree")
                || spinner4Choice.equalsIgnoreCase("Somewhat Disagree"))) {
            mAnimal = "red panda";
        }
        else if((spinner4Choice.equalsIgnoreCase("Agree")
                || spinner4Choice.equalsIgnoreCase("Somewhat Agree"))
                && (spinner5Choice.equalsIgnoreCase("Disagree")
                || spinner5Choice.equalsIgnoreCase("Somewhat Disagree"))) {
            mAnimal = "tiger";
        }
        else {
            getRandomAnimal();
        }
    }


    private void showAnimal() {
        Intent intent = new Intent(this, AnimalActivity.class);
        intent.putExtra("animal", mAnimal);
        startActivity(intent);
    }

    private void getRandomAnimal() {
        String[] animals = {"wolf", "flamingo", "hippo", "alligator", "snake"};
        Random rand = new Random();
        int randomNumber = rand.nextInt(5);
        mAnimal = animals[randomNumber];
    }
}
