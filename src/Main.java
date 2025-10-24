//Opret ordre (medarbejder)
//Vis menu på skærm V
//Vis og opdater ordreliste
//Markér ordre som færdig
//Gem afsluttede ordrer i database
//Se omsætning og statistik (ejer)


import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
                        System.out.println("_________________________");
                    }
                }


                case 2 -> {
                    System.out.println("Opret odre");

                    Scanner ordre = new Scanner(System.in);
                    List<Pizzaer> bestilling = new ArrayList<>();
                    System.out.println("Indtast pizzanr (0 for at afslutte):");

                    while (true) {
                        // vis alle pizzaer på menuen
                        for (int i = 0; i < Menu.hentMenu().size(); i++) {
                            Pizzaer p = Menu.hentMenu().get(i);
                            System.out.println((i + 1) + ". " + p.getNavn() + " - " + p.getPris() + " kr");
                        }

                        // læs brugerens valg og vælg pizza
                        System.out.println("Vælg pizza: ");
                        valg = ordre.nextInt();

                        if (valg == 0) {
                            break;
                        }

                        Pizzaer valgtPizza = Menu.hentMenu().get(valg - 1);
                        bestilling.add(valgtPizza);

                        System.out.println("Tak!, du har nu valgt pizza nr. " + valg);
                        System.out.println("Pris: " + valgtPizza.getPris() + " kr");

                        //tilføj topping
                        System.out.println("vælg Topping ja/nej ");
                        String svar = ordre.nextLine();
                        if (svar.equalsIgnoreCase("ja")){
                            boolean tilfoej = true;
                            while (tilfoej){
                                System.out.println("Vælg topping");
                                System.out.println();
                                System.out.println("1 Chili");
                                System.out.println("2 Bacon");
                                System.out.println("3 ekstra Dressing");
                                System.out.println("4 Ekstra ost");
                                System.out.println("5 Ananas");
                                System.out.println("6 Salat");
                                System.out.println("7 Champignon");
                                System.out.println("8 Kebab");
                                System.out.println("9 Skinke");
                                System.out.println("10 Tun");
                                System.out.println();
                                System.out.println("11 Færdig");

                                int t = ordre.nextInt();

                                switch (t){
                                 case 1 ->  valgtPizza.tilfoej(new Topping);
                                 case 2 -> valgtPizza.tilfoej(new Topping);
                                 case 3 -> valgtPizza.tilfoej(new Topping);
                                 case 4 -> valgtPizza.tilfoej(new Topping);
                                 case 5 -> tilfoej(new Topping);
                                 case 6 -> tilfoej(new Topping);
                                 case 7 -> tilfoej(new Topping);
                                 case 8 -> tilfoej(new Topping);
                                 case 9 -> tilfoej(new Topping);
                                 case 10 -> tilfoej(new Topping);
                                 case 11 -> tilfoej = false;
                                    default -> System.out.println("fejl");
                                }
                            }

                        }

                        //udskriv samlet ordre
                        System.out.println("===== DIN ORDRE =====");
                        int total = 0;
                        for (Pizzaer p : bestilling) {
                            System.out.println(p.getNavn() + " - " + p.getPris() + " kr ");
                            total += p.getPris();
                        }

                        System.out.println("Total pris: " + total + " kr");
                        System.out.println("Tak for din bestilling!");
                    }
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
