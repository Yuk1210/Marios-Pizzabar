//Se omsætning og statistik (ejer)

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static Omsætning omsætning =  new Omsætning();

    private static final String[] NAVNE = {
            "Anders", "Maria", "Jonas", "Laura", "Peter",
            "Emma", "Mikkel", "Sofie", "Thomas", "Ida"
    };

    public static String randomNavn() {
        Random random = new Random();
        return NAVNE[random.nextInt(NAVNE.length)];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bestillingsliste bestillingsliste = new Bestillingsliste();
        int næsteOrdrenr = 1;

        boolean run = true;
        while (run) {
            System.out.println(" 🍕Mario's Pizzabar 🍕");
            System.out.println("1. Se Pizzamenu");
            System.out.println("2. Opret Ordre");
            System.out.println("3: Vis aktive ordrer");
            System.out.println("4: Afslut ordre");
            System.out.println("5: Vis omsætningen ");
            System.out.println("6. Afslut program");
            System.out.println();
            System.out.print("Vælg: ");

            int valg = input.nextInt();
            input.nextLine();

            switch (valg) {
                case 1 -> {
                    System.out.println();
                    System.out.println("==== 🍕 MARIOS PIZZABAR 🍕====");
                    for (Pizzaer p : Menu.hentMenu()) {
                        System.out.println(p);
                        System.out.println("_______________________");
                    }
                }

                case 2 -> {
                    System.out.println();
                    System.out.println("Opret ny ordre");

                    String navn = randomNavn();
                    Kunde kunde = new Kunde(navn, String.valueOf(næsteOrdrenr));
                    System.out.println("Kunde: " + navn);
                    System.out.println("Ordrenummer: #" + næsteOrdrenr);

                    Scanner ordre = new Scanner(System.in);
                    List<Pizzaer> bestilling = new ArrayList<>();
                    int total = 0;
                    boolean done = false;

                    while (!done) {
                        // vis alle pizzaer på menuen
                        for (int i = 0; i < Menu.hentMenu().size(); i++) {
                            Pizzaer p = Menu.hentMenu().get(i);
                            System.out.println((i + 1) + ". " + p.getNavn() + " - " + p.getPris() + " kr");
                        }

                        // læs brugerens valg og vælg pizza
                        System.out.println("Vælg pizza # ");
                        valg = ordre.nextInt();
                        ordre.nextLine();
                        Pizzaer valgtPizza = Menu.hentMenu().get(valg - 1);
                        bestilling.add(valgtPizza);

                        System.out.println("Tak!, du har nu valgt pizza nr. " + valg);
                        System.out.println("Pris: " + valgtPizza.getPris() + " kr");

                        //tilføj topping
                        System.out.println("Vil du tilføje toppings ja/nej");
                        System.out.println("alle toppings koster en ekstra 10kr");

                        String svar = ordre.nextLine();
                        if (svar.equalsIgnoreCase("ja")) {
                            boolean tilfoej = true;
                            while (tilfoej) {
                                System.out.println();
                                System.out.println("Vælg topping");
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
                                System.out.println("11 Færdig");

                                int t = ordre.nextInt();
                                ordre.nextLine();

                                switch (t) {
                                    case 1 -> valgtPizza.tilfoej(new Topping("Chili"));
                                    case 2 -> valgtPizza.tilfoej(new Topping("Bacon"));
                                    case 3 -> valgtPizza.tilfoej(new Topping("Ekstra Dressing"));
                                    case 4 -> valgtPizza.tilfoej(new Topping("Ekstra Ost"));
                                    case 5 -> valgtPizza.tilfoej(new Topping("Ananas"));
                                    case 6 -> valgtPizza.tilfoej(new Topping("Salat"));
                                    case 7 -> valgtPizza.tilfoej(new Topping("Champignon"));
                                    case 8 -> valgtPizza.tilfoej(new Topping("Kebab"));
                                    case 9 -> valgtPizza.tilfoej(new Topping("Skinke"));
                                    case 10 -> valgtPizza.tilfoej(new Topping("Tun"));
                                    case 11 -> tilfoej = false;
                                    default -> System.out.println("fejl, prøv igen");
                                }
                            }
                        }
                        //Vider bestille eller færdig
                        System.out.println("1: Vider bestille");
                        System.out.println("2: Ordre færdig");
                        String færdigSvar = ordre.nextLine();
                        if (færdigSvar.equalsIgnoreCase("2")) {
                            done = true;
                        }
                    }

                    //Beregn total
                    total = 0;
                    for (Pizzaer p : bestilling) {
                        total += p.getPris();
                    }

                    // Når du opretter en ordre
                    Ordre ordreObj = new Ordre(næsteOrdrenr, kunde);
                    for (Pizzaer p : bestilling) {
                        ordreObj.tilføjPizza(p);
                    }
                    // Gem ordren i omsætningen
                    omsætning.tilføjOrdre(ordreObj);
                    System.out.println();
                    System.out.println(" Ordren er gemt i omsætningen!");

                    List<Ordre> gemListe = new ArrayList<>();
                    gemListe.add(ordreObj);
                    OrdrePersistens.ordrePersistens(gemListe);


                    //udskriv samlet ordre
                    System.out.println("===== DIN ORDRE =====");
                    for (Pizzaer p : bestilling) {
                        System.out.println(p.getNavn() + " - " + p.getPris() + " kr ");

                        //Tjek efter toppings
                        if (!p.getToppings().isEmpty()) {
                            System.out.println("  Toppings:  ");
                            for(int i = 0; i < p.getToppings().size(); i++) {
                                System.out.println(p.getToppings().get(i).getNavn());
                                if (i < p.getToppings().size() - 1) {
                                }
                            }
                            System.out.println();
                        }
                    }
                    System.out.println("Total pris: " + total + " kr");
                    System.out.println("Tak for din bestilling!");
                    bestillingsliste.tilføjOrdre(ordreObj);
                    næsteOrdrenr++;
                    System.out.println("=====================");
                    System.out.println();
                }

                case 3 -> {
                    System.out.println();
                    bestillingsliste.visAktiveOrdre();
                    System.out.println();
                }

                case 4 -> {
                    System.out.println();
                    System.out.println("Indtast ordrenummer der skal afsluttes:");
                    int afslutNr= input.nextInt();
                    bestillingsliste.afslutOrdre(afslutNr);
                    Ordre afsluttet = bestillingsliste.findOrdre(afslutNr); // hent ordren
                    System.out.println("Ordre #" + afslutNr + " er nu afsluttet");
                    System.out.println();
                }

                case 5 -> {
                    omsætning.visOmsætning();
                    System.out.println("==============================");
                    System.out.println("\n");

                }
                case 6 -> {
                    run = false;
                    System.out.println(" Program aflsuttes. 🍕Tak for idag! 🍕");
                }
                default -> System.out.println("Fejl!");

            }

        }
    }
}