package com.example.activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText4;
    Button button4;
    int difference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        editText4 = findViewById(R.id.et4);
        button4 = findViewById(R.id.btn4);

        button4.setOnClickListener(this);

        Intent i = getIntent();
        int number1 = i.getIntExtra("key1",0);
        int number2 = i.getIntExtra("key2",0);

        difference = number1 - number2;
        editText4.setText(difference+"");
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent();
        i.putExtra("subtraction",difference);
        setResult(RESULT_OK,i);
        finish();

    }
}
