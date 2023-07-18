package ru.petrkalash.task9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linearLayoutMain;
    RadioGroup radioGroupGravity;
    RadioButton radioButtonLeft;
    RadioButton radioButtonCenter;
    RadioButton radioButtonRight;
    EditText editTextName;
    Button buttonCreate;
    Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Вертикальный LinearLayout, в котором будут создаваться компоненты
        linearLayoutMain = findViewById(R.id.linearLayoutMain);

        radioGroupGravity = findViewById(R.id.radioGroupGravity);
        radioButtonLeft = findViewById(R.id.radioButtonLeft);
        radioButtonCenter = findViewById(R.id.radioButtonCenter);
        radioButtonRight = findViewById(R.id.radioButtonRight);
        editTextName = findViewById(R.id.editTextName);

        buttonCreate = findViewById(R.id.buttonCreate);
        // Метод, прослушивающий нажатие на кнопку
        buttonCreate.setOnClickListener(this);

        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);
    }

    // В качестве обработчика назначаем Activity, а метод для обработки - onClick
    @SuppressLint({"RtlHardcoded", "NonConstantResourceId"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonCreate:
                // Создание LayoutParams с шириной и высотой по содержимому
                LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                switch(radioGroupGravity.getCheckedRadioButtonId()) {
                    case -1:
                        Toast.makeText(this, "Ничего не выбрано!", Toast.LENGTH_SHORT).show();
                        return;
                    case R.id.radioButtonLeft:
                        linearParams.gravity = Gravity.LEFT;
                        break;
                    case R.id.radioButtonCenter:
                        linearParams.gravity = Gravity.CENTER;
                        break;
                    case R.id.radioButtonRight:
                        linearParams.gravity = Gravity.RIGHT;
                        break;
                }
                // Создание новой кнопки на поле Layout
                Button buttonNew = new Button(this);
                buttonNew.setText(editTextName.getText());

                // Изменение текста после нажатия на кнопку
                buttonNew.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        buttonNew.setText("Hello!");
                    }
                });

                // Добавляем созданный Button в LinearLayout
                linearLayoutMain.addView(buttonNew, linearParams);
                break;
            case R.id.buttonClear:
                // Удаление всех дочерних View-элементов с LinearLayout
                linearLayoutMain.removeAllViews();
                Toast.makeText(this, "Button Delete!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}