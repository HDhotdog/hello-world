//Octavio Laraia & Anneliese Keck

import java.util.ArrayList;
import java.util.Scanner;

enum Zutaten {
    TEIG, VOLLKORNTEIG, TOMATENSOSSE, SCHARFESOSSE, CREMEFRAICHE,
    SALAMI, SCHINKEN, PILZE, ANANAS, DOENERFLEISCH, ZWIEBELN, MAIS, BROKKOLI, EI;
}

public class Pizza {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] Zutaten = new String[5];
        ArrayList<String> Zutatenliste = new ArrayList<>(); //Liste für die allgemeinen Zutaten erstellen
        ArrayList<String> Pizzaliste = new ArrayList<>(); //Liste für Zutaten der Pizza

        Zutatenliste.add("TEIG");			//Alle verfügbaren Zutaten zur Liste hinzufuegen
        Zutatenliste.add("VOLLKORNTEIG");
        Zutatenliste.add("TOMATENSOSSE");
        Zutatenliste.add("SCHARFE SOSSE");
        Zutatenliste.add("CREME FRAICHE");
        Zutatenliste.add("SALAMI");
        Zutatenliste.add("SCHINKEN");
        Zutatenliste.add("PILZE");
        Zutatenliste.add("ANANAS");
        Zutatenliste.add("DOENERFLEISCH");
        Zutatenliste.add("ZWIEBELN");
        Zutatenliste.add("MAIS");
        Zutatenliste.add("BROKKOLI");
        Zutatenliste.add("EI");
        Zutatenliste.add("KAESE");

        boolean fleisch = false;
        boolean sosse = false;
        boolean gueltig = true;

        for (int i = 0; i < 5; i++) {
            Zutaten[i] = scanner.nextLine().toUpperCase(); //5 Zutaten einlesen
            if (!Zutatenliste.contains(Zutaten[i])) { //ungueltig wenn Zutat doppelte oder nicht vorhandene Zutat
                gueltig = false;
            }
            if (i == 0 && (!Zutaten[i].equals("TEIG") && !Zutaten[i].equals("VOLLKORNTEIG")) ) { //Ungültig wenn am Anfang kein Teig
                gueltig = false;
            }
            if (i == 4 && (!Zutaten[4].equals("KAESE"))){ //Ungueltig wenn Kaese nicht am Ende ist 
                gueltig = false;
            }
            if (Zutaten[i].equals("BROKKOLI")) { //Ungueltig wenn Brokkoli dabei ist
                gueltig = false;
            }
            if (Zutaten[i].equals("DOENERFLEISCH")) { 
                fleisch = true;
            }
            if (Zutaten[i].equals("SCHARFE SOSSE")) {
                sosse = true;
            }


            Zutatenliste.remove(Zutaten[i]); //Zutat von der allgemeinen Liste löschen
            Pizzaliste.add(Zutaten[i]); //Zutat auf die Zutatenliste der Pizza setzen
            
        }


        if ((fleisch || sosse) && !(fleisch && sosse)) { //ungueltig wenn sosse oder doenerfleisch aber nicht beides
            gueltig = false;
        }
        if(Pizzaliste.contains("TEIG") && Pizzaliste.contains("VOLLKORNTEIG")) { //ungueltig wenn zwei mal Teig 
            gueltig = false;
        }

        if(gueltig) {
            System.out.println("GÜLTIG"); //
        } else {
            System.out.println("UNGÜLTIG");
        }

    }
}
