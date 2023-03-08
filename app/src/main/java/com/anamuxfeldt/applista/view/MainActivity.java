package com.anamuxfeldt.applista.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anamuxfeldt.applista.R;
import com.anamuxfeldt.applista.controller.CursoController;
import com.anamuxfeldt.applista.controller.PessoaController;
import com.anamuxfeldt.applista.model.Curso;
import com.anamuxfeldt.applista.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;
    CursoController cursoController;

    Pessoa pessoa;
    List<Curso> listaDeCursos;
    EditText txtNome, txtSobrenome, txtCurso, txtTelefone;
    Button btnLimpar, btnSalvar, btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        cursoController.getlistaDeCursos();
        listaDeCursos = cursoController.getlistaDeCursos();

        pessoa = new Pessoa();
        controller.buscar(pessoa);
        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtCurso = findViewById(R.id.txtCurso);
        txtTelefone = findViewById(R.id.txtTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        txtNome.setText(pessoa.getPrimeiroNome());
        txtSobrenome.setText(pessoa.getSobrenome());
        txtCurso.setText(pessoa.getCurso());
        txtTelefone.setText(pessoa.getTelefone());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNome.setText("");
                txtSobrenome.setText("");
                txtCurso.setText("");
                txtTelefone.setText("");

                controller.limpar();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Volte Sempre",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(txtNome.getText().toString());
                pessoa.setSobrenome(txtSobrenome.getText().toString());
                pessoa.setCurso(txtCurso.getText().toString());
                pessoa.setTelefone(txtTelefone.getText().toString());
                Toast.makeText(MainActivity.this,
                        "Salvo " + pessoa.toString(),
                        Toast.LENGTH_LONG).show();




                controller.salvar(pessoa);

            }
        });


    }
}