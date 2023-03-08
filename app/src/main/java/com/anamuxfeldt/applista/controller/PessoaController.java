package com.anamuxfeldt.applista.controller;

import android.content.SharedPreferences;

import com.anamuxfeldt.applista.model.Pessoa;
import com.anamuxfeldt.applista.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor lista;
    public static final String NOME_PREFERENCES = "pref_lista";

    public PessoaController(MainActivity mainActivity) {
        preferences =
                mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        lista = preferences.edit();
    }

    public void salvar(Pessoa pessoa) {

        lista.putString("nome", pessoa.getPrimeiroNome());
        lista.putString("sobrenome", pessoa.getSobrenome());
        lista.putString("curso", pessoa.getCurso());
        lista.putString("telefone", pessoa.getTelefone());
        lista.apply();

    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(
                preferences.getString(
                        "PrimeiroNome", pessoa.getPrimeiroNome()
                )
        );
        pessoa.setPrimeiroNome(
                preferences.getString(
                        "Sobrenome", pessoa.getSobrenome()
                )
        );
        pessoa.setPrimeiroNome(
                preferences.getString(
                        "Telefone", pessoa.getTelefone()
                )
        );
        pessoa.setPrimeiroNome(
                preferences.getString(
                        "Curso", pessoa.getCurso()
                )
        );

        return pessoa;
    }

    public void limpar() {

        lista.clear();
        lista.apply();
    }


}
