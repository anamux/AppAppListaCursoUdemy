package com.anamuxfeldt.applista.controller;

import com.anamuxfeldt.applista.model.Curso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List listCursos;

    public List getlistaDeCursos(){

        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Android"));
        listCursos.add(new Curso("iOS"));
        listCursos.add(new Curso("PHP"));
        listCursos.add(new Curso("Phyton"));
        listCursos.add(new Curso("Flutter"));

        return listCursos;
    }

    public ArrayList<String> dadosParaSpinner(){

    ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getlistaDeCursos().size()  ; i++) {

            Curso objeto = (Curso) getlistaDeCursos().get(i);
            dados.add(objeto.getNomeDoCurso());
        }

        return dados;
    }

}
