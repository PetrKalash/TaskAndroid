package ru.petrkalash.task7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Константы для хранения ID пунктов меню
    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    // Элементы экрана
    TextView tv;
    CheckBox cb;

    // Контекстное меню
    TextView textColor;
    TextView textSize;

    // Метод для запуска Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.messageText);
        cb = findViewById(R.id.checkBoxMenu);

        textColor = findViewById(R.id.textColor);
        textSize = findViewById(R.id.textSize);

        // Включение контекстного меню для определенного View
        registerForContextMenu(textColor);
        // Второй способ создания обработчика - как у обычного меню
        textSize.setOnCreateContextMenuListener(this);
    }

    // Создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        Без использования xml-файла

//        menu.add(0, 1, 0, "Add");
//        menu.add(0, 2, 0, "Edit");
//        menu.add(0, 3, 3, "Delete");
//        menu.add(1, 4, 1, "Copy");
//        menu.add(1, 5, 2, "Paste");
//        menu.add(1, 6, 4, "Exit");

        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Пункты меню с groupId. 1 - видны, если на CheckBox стоит галочка
        menu.setGroupVisible(R.id.group1, cb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    // Обработка нажатий
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Массив символов
        StringBuilder sb = new StringBuilder();
        sb.append("\ngroupId: ").append((item.getGroupId()));
        sb.append("\nitemId: ").append((item.getItemId()));
        sb.append("\norder: ").append((item.getOrder()));
        sb.append("\ntitle: ").append((item.getTitle()));
        tv.setText(sb);

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.textColor:
                getMenuInflater().inflate(R.menu.context_menu, menu);
//                menu.add(0, MENU_COLOR_RED, 0, "Red");
//                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
//                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                break;
            case R.id.textSize:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getOrder()) {
            case 1:
                textColor.setTextColor(Color.RED);
                break;
            case 2:
                textColor.setTextColor(Color.BLUE);
                break;
            case 3:
                textColor.setTextColor(Color.GREEN);
                break;
        }

        switch (item.getItemId()) {
            case MENU_SIZE_22:
                textSize.setTextSize(22);
                break;
            case MENU_SIZE_26:
                textSize.setTextSize(26);
                break;
            case MENU_SIZE_30:
                textSize.setTextSize(30);
                break;
        }
        return super.onContextItemSelected(item);
    }
}