package com.company;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.*;


public class Main {

    private static final String foutmelding = "\nU dient een geldige keuze in te geven!\n";

    private static ArrayList<Film> filmlijst = new ArrayList<>();



    public static void main(String[] args) {

        filmsLezenUitBestand();

        menuTonen();

        filmsSchrijvenInBestand();
    }


    private static void filmsLezenUitBestand() {


        try (Scanner reader = new Scanner(new BufferedReader(new FileReader("films.txt")))) {


            String titelFilm = "";
            String regisseur = "";
            String jaarUitgebracht = "";

            while (reader.hasNextLine()) {

                titelFilm = reader.nextLine();
                regisseur = reader.nextLine();
                jaarUitgebracht = reader.nextLine();

                filmlijst.add(new Film(titelFilm, regisseur, jaarUitgebracht));
            }

        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }

    }


    private static void menuTonen() {

        Scanner scanner = new Scanner(System.in);

        String keuze;

        do {       // Geen fout in deze do-while

            System.out.println("\nMENU");
            System.out.println("______________________________________");

            System.out.println("1. Geef films in");
            System.out.println("2. Een lijst van films opvragen");


            System.out.println("\n<ENTER> om te stoppen\n");

            System.out.print("Keuze: ");

            keuze = scanner.nextLine();

            if (!keuze.equalsIgnoreCase("")) {


                if (keuze.equals("1"))
                    filmsIngeven();

                else if (keuze.equals("2"))
                    filmsTonen();

                else
                    System.out.println(foutmelding);

            }
        } while (!keuze.equalsIgnoreCase(""));


        System.out.println("\n\tEINDE PROGRAMMA");

    }


    private static void filmsIngeven() {


        Scanner scanner = new Scanner(System.in);


        String titelFilm = "";
        String regisseur = "";
        String jaarUitgebracht = "";


        do {       // Geen fout in deze do-while

            System.out.print("\nGeef films in:\n\n");
            System.out.print("Geef titel: <ENTER> om te stoppen: ");

            titelFilm = scanner.nextLine();

            if (!titelFilm.equalsIgnoreCase("")) {


                System.out.print("Weet u de regisseur ? ");

                regisseur = scanner.nextLine();

                System.out.print("Weet u het jaar dat de film is uitgebracht? ");

                jaarUitgebracht = scanner.nextLine();

                filmlijst.add(new Film(titelFilm, regisseur, jaarUitgebracht));


            }

        } while (!titelFilm.equalsIgnoreCase(""));

    }


    private static void filmsTonen() {


        System.out.println("\nLijst van films:\n");


        if (filmlijst.isEmpty())
            System.out.println("U hebt nog geen films ingegeven.\n");

        else {

            for (Film film : filmlijst) {
                System.out.printf("Titel: %s\n", film.getFilmTitel());
                System.out.printf("Regisseur:  %s\n", film.getRegisseur());
                System.out.printf("Jaar uitgebracht: %s\n\n", film.getJaarUitgebracht());
            }
            System.out.println();
        }


        String keuze;

        Scanner scanner = new Scanner(System.in);

        do {        // Geen fout in deze do-while

            System.out.println("\nWilt u een film wijzigen of verwijderen ?\n");
            System.out.println("1 Wijzigen\t 2 Verwijderen\t <ENTER> om te stoppen");
            System.out.print("\nKeuze: ");

            keuze = scanner.nextLine();

            if (!keuze.equals("")) {

                if (keuze.equals("1"))
                    filmWijzigen();

                else if (keuze.equals("2"))
                    filmVerwijderen();

                else
                    System.out.println(foutmelding);
            }

        } while (!keuze.equals(""));

    }


    private static void filmVerwijderen() {  // In deze methode zitten nog onvolmaaktheden.

        Scanner scanner = new Scanner(System.in);


        System.out.println("\nFilm verwijderen:\n");
        System.out.print("Geef de titel van de film (hoofdletters moeten niet) : ");


        String titelTeZoeken = scanner.nextLine();

        boolean gevonden = false;


        Iterator <Film> iterator = filmlijst.iterator();

        while (iterator.hasNext()) {

            Film film = iterator.next();

                if (film.getFilmTitel().equalsIgnoreCase(titelTeZoeken)) {

                    iterator.remove();

                    gevonden = true;
                    System.out.printf("\nFilm \"%s\" verwijderd.\n", film.getFilmTitel());
                }
            }


        if (!gevonden)
            System.out.println("\nDit is geen geldige titel.\n");
    }


    private static void filmWijzigen() {    // In deze methode zitten nog onvolmaaktheden.

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nFilm wijzigen:\n");
        System.out.print("Geef de titel van de film: ");

        String titelTeZoeken = scanner.nextLine();

        boolean gevonden = false;


        Iterator <Film> iterator = filmlijst.iterator();

        while (iterator.hasNext()) {

            Film film = iterator.next();

            if (film.getFilmTitel().equalsIgnoreCase(titelTeZoeken)) {

                gevonden = true;

                boolean ietsWijzigen = true;

                do {    // Geen fout in deze do-while

                    System.out.println("\nWat wilt u wijzigen ?\t 1 Titel\t 2 Regisseur\t 3 Jaar\t <ENTER> om te stoppen");
                    System.out.print("\nKeuze: ");

                    String keuze = scanner.nextLine();

                    if (!keuze.equals("")) {


                        switch (keuze) {
                            case "1":
                                System.out.print("\nGeef de nieuwe titel: ");
                                String nieuweTitel = scanner.nextLine();

                                film.setFilmTitel(nieuweTitel);

                                System.out.printf("\nTitel gewijzigd naar \"%s\"\n", film.getFilmTitel());
                                break;

                            case "2":
                                System.out.print("\nGeef de nieuwe regisseur: ");
                                String nieuweRegisseur = scanner.nextLine();

                                film.setRegisseur(nieuweRegisseur);

                                System.out.printf("\nRegisseur gewijzigd naar \"%s\"\n", film.getRegisseur());
                                break;

                            case "3":
                                System.out.print("\nGeef het nieuwe jaar: ");
                                String nieuwJaar = scanner.nextLine();

                                film.setJaarUitgebracht(nieuwJaar);

                                System.out.printf("\nJaar gewijzigd naar \"%s\"\n", film.getJaarUitgebracht());
                                break;

                            default:
                                System.out.println(foutmelding);

                                break;
                        }

                    } else
                        ietsWijzigen = false;

                } while (ietsWijzigen);
            }
        }

        if (!gevonden)
            System.out.println("\nDit is geen geldige titel.\n");

    }


    private static void filmsSchrijvenInBestand() {


        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("films.txt"))))

        {

            for (Film film : filmlijst) {

                pw.printf("%s%n", film.getFilmTitel());
                pw.printf("%s%n", film.getRegisseur());
                pw.printf("%s%n", film.getJaarUitgebracht());
            }

        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }

    }

}

