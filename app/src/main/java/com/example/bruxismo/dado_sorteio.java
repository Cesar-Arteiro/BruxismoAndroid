package com.example.bruxismo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class dado_sorteio {

    @SerializedName("tema")
    @Expose
    private String tema;

    @SerializedName("numero")
    @Expose
    private int numero;

    @SerializedName("data")
    @Expose
    private Date data;

    @SerializedName("numerosSorteados")
    @Expose
    private Date numerosSorteados;



    public dado_sorteio(String tema, int numero, Date data, Date numerosSorteados) {
        this.tema = tema;
        this.numero = numero;
        this.data = data;
        this.numerosSorteados = numerosSorteados;
    }
    public String getTema() {
        return tema;
    }

    public int getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public Date getNumerosSorteados() {
        return numerosSorteados;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setNumerosSorteados(Date numerosSorteados) {
        this.numerosSorteados = numerosSorteados;
    }
}
