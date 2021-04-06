package com.example.rsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText pText, qText, msgText, resText;
    Button genBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pText = findViewById(R.id.pText);
        qText = findViewById(R.id.qText);
        msgText = findViewById(R.id.msgText);
        resText = findViewById(R.id.resText);
        genBtn = findViewById(R.id.genBtn);

        genBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pString = Integer.parseInt(String.valueOf(pText.getText()));
                int qString = Integer.parseInt(String.valueOf(qText.getText()));
                int msgString = Integer.parseInt(String.valueOf(msgText.getText()));
                resText.setText(""+pString);
            }
        });
    }
}
/*
  
*/