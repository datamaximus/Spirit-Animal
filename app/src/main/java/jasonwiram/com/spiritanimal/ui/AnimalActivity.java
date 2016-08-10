package jasonwiram.com.spiritanimal.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import jasonwiram.com.spiritanimal.R;

public class AnimalActivity extends AppCompatActivity {

    private String mName;
    private ImageView mImageView;
    private EditText mEditText;
    private TextView mCaptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        mImageView = (ImageView)findViewById(R.id.animalImageView);
        mEditText = (EditText)findViewById(R.id.editText);
        mCaptionTextView = (TextView)findViewById(R.id.captionTextView);

        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ( (actionId == EditorInfo.IME_ACTION_DONE) || ((event.getKeyCode() == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_DOWN ))){
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    View focus = getCurrentFocus();
                    if(focus != null) {
                        inputManager.hideSoftInputFromWindow(focus.getWindowToken(), 0);
                        mEditText.setVisibility(View.INVISIBLE);
                        mCaptionTextView.setText(mEditText.getText());
                        mCaptionTextView.setVisibility(View.VISIBLE);
                        Toast toast = Toast.makeText(AnimalActivity.this, "Press back button to play again", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP,0,48);
                        toast.show();
                    }
                    return true;
                }
                else{
                    return false;
                }
            }
        });

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
        else if(animal.equalsIgnoreCase("red panda")) {
            Drawable drawable = getResources().getDrawable(R.drawable.redpanda, null);
            mImageView.setImageDrawable(drawable);
        }
        else if(animal.equalsIgnoreCase("tiger")) {
            Drawable drawable = getResources().getDrawable(R.drawable.tiger, null);
            mImageView.setImageDrawable(drawable);
        }
        else if (animal.equalsIgnoreCase("wolf")) {
            Drawable drawable = getResources().getDrawable(R.drawable.wolf, null);
            mImageView.setImageDrawable(drawable);
        }
        else if (animal.equalsIgnoreCase("flamingo")) {
            Drawable drawable = getResources().getDrawable(R.drawable.flamingo, null);
            mImageView.setImageDrawable(drawable);
        }
        else if (animal.equalsIgnoreCase("hippo")) {
            Drawable drawable = getResources().getDrawable(R.drawable.hippo, null);
            mImageView.setImageDrawable(drawable);
        }
        else if (animal.equalsIgnoreCase("alligator")) {
            Drawable drawable = getResources().getDrawable(R.drawable.alligator, null);
            mImageView.setImageDrawable(drawable);
        }
        else if (animal.equalsIgnoreCase("snake")) {
            Drawable drawable = getResources().getDrawable(R.drawable.snake, null);
            mImageView.setImageDrawable(drawable);
        }
    }
}
