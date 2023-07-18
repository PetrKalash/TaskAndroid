package ru.petrkalash.task8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Метод вызывается, когада мы создаем activity в первый раз
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Верхнее меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("menu1");
        menu.add("menu2");
        return super.onCreateOptionsMenu(menu);
    }

    // Обработка нажатой кнопки меню
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}