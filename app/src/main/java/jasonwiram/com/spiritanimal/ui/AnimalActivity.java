package jasonwiram.com.spiritanimal.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

import jasonwiram.com.spiritanimal.R;

public class AnimalActivity extends AppCompatActivity {

    private String mName;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        mImageView = (ImageView)findViewById(R.id.animalImageView);

        Intent intent = getIntent();
        mName = intent.getStringExtra("animal");
        Toast toast = Toast.makeText(AnimalActivity.this, "Your spirit animal is a " + mName, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,48);
        toast.show();
        checkAnimal(mName);
    }

    private void checkAnimal(String animal) {
        if(animal.equalsIgnoreCase("elephant")) {
            Drawable drawable = getResources().getDrawable(R.drawable.elephant, null);
            mImageView.setImageDrawable(drawable);
        }
        else if(animal.equalsIgnoreCase("dolphin")) {
            Drawable drawable = getResources().getDrawable(R.drawable.dolphin, null);
            mImageView.setImageDrawable(drawable);
        }
        else if(animal.equalsIgnoreCase("monkey")) {
            Drawable drawable = getResources().getDrawable(R.drawable.monkey, null);
            mImageView.setImageDrawable(drawable);
        }
        else if(animal.equalsIgnoreCase("redpanda")) {
            Drawable drawable = getResources().getDrawable(R.drawable.redpanda, null);
            mImageView.setImageDrawable(drawable);
        }
        else if(animal.equalsIgnoreCase("tiger")) {
            Drawable drawable = getResources().getDrawable(R.drawable.tiger, null);
            mImageView.setImageDrawable(drawable);
        }
        else {
            mImageView = mImageView;
        }
    }
}
