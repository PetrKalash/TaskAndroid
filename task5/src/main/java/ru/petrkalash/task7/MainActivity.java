package ru.petrkalash.task7;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("myLog", "Find View Elements");
        TextView text = (TextView) findViewById(R.id.name);
        text.setText(R.string.app_name);

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setBackgroundColor(Color.WHITE);

        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button1: {
                btn1.setBackgroundColor(Color.BLACK);
                Toast.makeText(this, "btn1 clicked!", Toast.LENGTH_LONG).show();
                btn1.setText("Наж");
                break;
            }
            case R.id.button2: {
                Toast.makeText(this, "btn2 clicked!", Toast.LENGTH_SHORT).show();
                btn2.setText("ата!");
                break;
            }
        }
    }
}