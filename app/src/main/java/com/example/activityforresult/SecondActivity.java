package com.example.activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtext;
    Button button3;
    int summation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtext = findViewById(R.id.et1);
        button3 = findViewById(R.id.btn3);

        button3.setOnClickListener(this);

        Intent i = getIntent();
        int number1 = i.getIntExtra("key1", 0);
        int number2 = i.getIntExtra("key2", 0);
        int summation = number1 + number2;
        edtext.setText(summation + "");


    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent();
        i.putExtra("addition", summation);
        Log.d("TAG", "onClick:                       summation"+summation);
        setResult(RESULT_OK, i);
        finish();


    }


}
