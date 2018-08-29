package com.company;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.FileReader;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;


public class Main {

    private static final String foutmelding = "\nU dient een geldige keuze in te geven!\n";

    private static ArrayList <Film> filmlijst = new ArrayList<>();


    public static void main(String[] args) {

        menuTonen();


    }


    private static void menuTonen() {

        Scanner scanner = new Scanner(System.in);

        String input;

        do {

            System.out.println("\nMENU");
            System.out.println("______________________________________");

            System.out.println("1. Geef films in");
            System.out.println("2. Een lijst van films opvragen\n");

            System.out.println("\n<return> om te stoppen\n");

            System.out.print("Keuze: ");

            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("")) {

                int keuze = Integer.parseInt(input);


                if (keuze == 1)
                    filmsIngeven();

                else if (keuze == 2)
                    filmsTonen();

                else
                    System.out.println(foutmelding);

            }
        } while(!input.equalsIgnoreCase("") );


        System.out.println("\n\tEINDE PROGRAMMA");

    }



private static void filmsIngeven() {


    Scanner scanner = new Scanner(System.in);


    String titelFilm = "";
    String regisseur = "";
    int jaarUitgebracht;


    do {
        System.out.print("\nGeef films in:\n\n");
        System.out.print("Geef titel: <return> om te stoppen: ");

        titelFilm = scanner.nextLine();

        if (!titelFilm.equalsIgnoreCase("")) {


            System.out.print("Weet u de regisseur ? ");

            regisseur = scanner.nextLine();

            System.out.print("Weet u jaar dat de film is uitgebracht? ");

            jaarUitgebracht = Integer.parseInt(scanner.nextLine());

            filmlijst.add(new Film(titelFilm, regisseur, jaarUitgebracht));
        }


    } while (!titelFilm.equalsIgnoreCase(""));


}


private  static void filmsTonen() {
        System.out.println("\nLijst van alle ingegeven films:\n");

        for (Film film: filmlijst) {
            System.out.printf("Titel: %s\n", film.getFilmTitel());
            System.out.printf("Regisseur:  %s\n", film.getRegisseur());
            System.out.printf("Jaar uitgebracht: %d\n", film.getJaarUitgebracht());
            System.out.println("");
        }

    }

    private static void filmsSchrijvenNaarBestand() {


        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(films.txt))))

        {

            pw.print("<html><body><table>\n"
                    + "<thead>\n"
                    + "<tr><th>Rekeningnummer</th><th>Saldo</th></tr>\n"
                    + "</thead>\n"
                    + "<tbody>\n");


            for ( String rekeningnummer : bank.getRekeningnummers()){

                BankRekening br = bank.getRekening(rekeningnummer);

                pw.printf("<tr><td>%s</td><td>%.2f</td></tr>\n", br.getRekeningnummer(), br.getSaldo());
            }

            pw.print("</tbody>\n" +
                    "</table>\n" +
                    "</body></html>");

        } catch (IOException e) {

            System.out.println("IOException: " +  e.getMessage());
        }



    }

}

