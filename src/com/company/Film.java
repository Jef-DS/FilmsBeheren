package com.company;



public class Film {

    private String filmTitel;
    private String jaarUitgebracht;
    private String regisseur;


    public Film(String filmTitel, String regisseur, String jaarUitgebracht) {


        this.filmTitel = filmTitel;

        if (regisseur.equals(""))
            this.regisseur = "Onbekend";
        else
            this.regisseur = regisseur;


        if (jaarUitgebracht.equals(""))
            this.jaarUitgebracht = "Onbekend";
        else
            this.jaarUitgebracht = jaarUitgebracht;
    }


    public String getFilmTitel() {

        return this.filmTitel;
    }


    public String getJaarUitgebracht() {

        return this.jaarUitgebracht;
    }


    public String getRegisseur() {

        return this.regisseur;
    }
}
