package ru.petrkalash.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myText = (TextView) findViewById(R.id.myText);
        myText.setText("Petr Kalash");

        Button myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setText("Ok");
        myBtn.setEnabled(false);

        CheckBox myCheck = (CheckBox) findViewById(R.id.myCheck);
        myCheck.setText("False");
        myCheck.setChecked(true);
    }
}