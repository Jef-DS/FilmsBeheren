package com.company;



public class Film {

    private String filmTitel;
    private int jaarUitgebracht;
    private String regisseur;


    public Film(String filmTitel, String regisseur, int jaarUitgebracht) {

        this.filmTitel = filmTitel;
        this.regisseur = regisseur;
        this.jaarUitgebracht = jaarUitgebracht;
    }


    public Film(String filmTitel) {
        this.filmTitel = filmTitel;
    }

    public String getFilmTitel() {
        return this.filmTitel;
    }


    public int getJaarUitgebracht() {

        return this.jaarUitgebracht;
    }

    public String getRegisseur() {

        return this.regisseur;
    }
}
