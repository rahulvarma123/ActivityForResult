package com.example.activityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit1, edit2, edit3;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        edit1 = findViewById(R.id.et1);
        edit2 = findViewById(R.id.et2);
        edit3 = findViewById(R.id.et3);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1 = Integer.parseInt(edit1.getText().toString());
        int num2 = Integer.parseInt(edit2.getText().toString());

        if (v.getId() == R.id.btn1) {
            Intent i = new Intent(this, SecondActivity.class);

            i.putExtra("key1", num1);
            i.putExtra("key2", num2);

            startActivityForResult(i, 123);
        } else if (v.getId() == R.id.btn2) {
            Intent i = new Intent(this, ThirdActivity.class);

            i.putExtra("key1", num1);
            i.putExtra("key2", num2);

            startActivityForResult(i, 456);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        if (resultCode == RESULT_OK) {
            if (requestCode == 123) {
                int sum = i.getIntExtra("addition", 0);
                Log.d("TAG", "onActivityResult:                      sum" + sum);
                edit3.setText(sum + "");
            }
            else if (requestCode == 456) {
                int diff = i.getIntExtra("subtraction", 0);
                edit3.setText(diff + "");
            }
        }

    }
}
