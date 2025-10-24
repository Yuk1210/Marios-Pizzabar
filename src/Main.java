//Opret ordre (medarbejder)
//Vis menu på skærm V
//Vis og opdater ordreliste
//Markér ordre som færdig
//Gem afsluttede ordrer i database
//Se omsætning og statistik (ejer)


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean run = true;

        while (run) {
            System.out.println(" Mario Pizzabar");
            System.out.println("1. Se Pizzamenu");
            System.out.println("2. Opret Ordre");
            System.out.println("3. Afslut program");

            int valg = input.nextInt();
            input.nextLine();

            switch (valg) {
                case 1 -> {
                    System.out.println("visMenu");
                    System.out.println("==== MARIOS PIZZABAR ====");
                    for (Pizzaer p : Menu.hentMenu()) {
                        System.out.println(p);
                        System.out.println("_________________________\n");
                    }
                }

                case 2 -> {
                    System.out.println("opret Ordre");

                    Scanner ordre = new Scanner(System.in);
                    System.out.println("Indtast pizzanr: ");
                    // vis alle pizzaer på menuen
                    for (int i = 0; i < Menu.hentMenu().size(); i++) {
                        Pizzaer p = Menu.hentMenu().get(i);
                        System.out.println((i + 1) + ". " + p.getNavn());
                    }
                    // læs brugerens valg
                    valg = ordre.nextInt();

                    // hent den valgte pizza fra listen ( minus 1 fordi lister starter på 0.
                    Pizzaer valgtPizza = Menu.hentMenu().get(valg - 1);

                    System.out.println("Tak!, du har nu valgt pizza " + valg);
                    System.out.println("Pris: " + valgtPizza.getPris() + " kr");
                }

                case 3 -> {
                    run = false;
                    System.out.println("Program afsluttet");
                }
                default -> System.out.println("Fejl!");
            }
        }
    }
}
