package ru.petrkalash.task8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        // Вертикальная ориентация
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        // Установка linearLayout как корневой элемент экрана
        setContentView(linearLayout, layoutParams);

        // Добавление в LinearLayout View-компоненты (высота и ширина определена по содержимому - wrap_content)
        LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        // Добавляем отступы с помощью LayoutParams
        lpView.leftMargin = 50;

        TextView tv = new TextView(this);
        tv.setText("Hello, ");
        // Добавление TextView в LinearLayout и присвоение ему указанный LayoutParams
        linearLayout.addView(tv, lpView);

        Button btn = new Button(this);
        btn.setText("World!");
        linearLayout.addView(btn, lpView);

        // Создаем новый отдельный компонент с выравниваем (то же самое можно сделать и для margin)
        LinearLayout.LayoutParams centerGravityParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        centerGravityParams.gravity = Gravity.CENTER;

        Button btnCenter = new Button(this);
        btnCenter.setText("Center!");
        linearLayout.addView(btnCenter, centerGravityParams);
    }
}