package com.company;



public class Film {

    private String filmTitel;
    private String jaarUitgebracht;
    private String regisseur;


    public Film(String filmTitel, String regisseur, String jaarUitgebracht) {

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


    public String getJaarUitgebracht() {

        if (this.jaarUitgebracht.equals(""))
            return "Onbekend";

        return this.jaarUitgebracht;
    }

    public String getRegisseur() {


        if (this.regisseur.equals(""))
            return "Onbekend";

        return this.regisseur;
    }
}
