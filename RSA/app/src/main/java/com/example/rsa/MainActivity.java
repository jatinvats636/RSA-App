package com.example.rsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.math.BigDecimal;
import java.math.BigInteger;

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
                int i, n, on, e, d=0;    //// e(public key exponent) & d(private key exponent)
                double enc;
                int p = Integer.parseInt(String.valueOf(pText.getText()));
                int q = Integer.parseInt(String.valueOf(qText.getText()));
                int plainText = Integer.parseInt(String.valueOf(msgText.getText()));
                resText.setText("p : "+p +"\n"+ "q : "+q +"\n"+ "InMsg : "+plainText);
                n = p * q;
                on = (p - 1) * (q - 1);
                resText.append("\n\nn : "+n +"\n"+ "ϕ(n) : "+on);
                for (e = 2; e < on; e++) {
                    if (gcd(e, on) == 1) {
                        break;
                    }
                }
                resText.append("\n\ne : "+e);
                for (i = 0; i <= 9; i++) {
                    int x = 1 + (i * on);
                    if (x % e == 0) {
                        d = x / e;
                        break;
                    }
                }
                resText.append("\nd : "+d);
                enc = (Math.pow(plainText, e)) % n;
                resText.append("\nEncrypted : "+enc);
                BigInteger N = BigInteger.valueOf(n);
                BigInteger C = BigDecimal.valueOf(enc).toBigInteger();
                BigInteger dec = (C.pow(d)).mod(N);
                resText.append("\nDecrypted : "+dec);
            }
        });
    }
    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}