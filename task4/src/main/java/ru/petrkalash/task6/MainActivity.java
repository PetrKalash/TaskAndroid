package ru.petrkalash.task6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOk;
    private Button btnCancel;

    private Button actiBtnOk;
    private Button actiBtnCancel;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        View.OnClickListener oclBtn = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnOk: {
                        btnOk.setText("Нажата!");
                        break;
                    }
                    case R.id.btnCancel: {
                        btnCancel.setText("И эта нажата!");
                        break;
                    }
                }
            }
        };

        // Присваиваем кнопкам один и тот же обработчик
        btnOk.setOnClickListener(oclBtn);
        btnCancel.setOnClickListener(oclBtn);

        // Мы прописали Interface в Main, а это - реализация метода. Этот метод уже реализован в
        // Activity и будет выступать обработчиком
        actiBtnOk = (Button) findViewById(R.id.actiBtnOk);
        actiBtnCancel = (Button) findViewById(R.id.actiBtnCancel);

        // Присваиваем кнопкам один и тот же обработчик
        actiBtnOk.setOnClickListener(this);
        actiBtnCancel.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.actiBtnOk: {
                actiBtnOk.setText("Activity Нажата!");
                break;
            }
            case R.id.actiBtnCancel: {
                actiBtnCancel.setText("И эта Activity нажата!");
            }
        }
    }
}