package com.anamuxfeldt.applista.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anamuxfeldt.applista.R;
import com.anamuxfeldt.applista.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
    }
}