package com.example.myshows;

public class Serie {
    private String nomeSerie;
    private int episodio;
    private String categoria;

    public Serie() {    }

    public Serie(String nomeSerie, int episodio, String categoria) {
        this.nomeSerie = nomeSerie;
        this.episodio = episodio;
        this.categoria = categoria;
    }



    public String getNomeSerie() {
        return nomeSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public int getEpisodio() {
        return episodio;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

