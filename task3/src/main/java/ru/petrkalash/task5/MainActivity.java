package ru.petrkalash.task5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Поиск View-элементов
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        // Создание объекта oclBtnOk, который реализует интерфейс View.OnClickListener (объект содержит метод onClick)
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            // Вызываем этот метод после нажатия кнопки
            public void onClick(View v) {
                btnOk.setText("Complete!");
            }
        };

        // Присваиваем обработчик кнопке Ok
        btnOk.setOnClickListener(oclBtnOk);

        View.OnClickListener oclBtnCancel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCancel.setTextColor(Color.BLACK);
            }
        };

        // Присваиваем значение кнопке
        btnCancel.setOnClickListener(oclBtnCancel);
    }
}