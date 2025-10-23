//Opret ordre (medarbejder)
//Vis menu på skærm V
//Vis og opdater ordreliste
//Markér ordre som færdig
//Gem afsluttede ordrer i database
//Se omsætning og statistik (ejer)


import java.util.Scanner;

public class Main {


    public static void main(String [] args) {
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
                case 1 -> visMenu();
                case 3 -> {
                    run = false;
                    System.out.println("Program afsluttet");
                }
                default -> System.out.println("Fejl!");
            }
        }
    }


    public static void visMenu(){
        System.out.println("==== MARIOS PIZZABAR ====");
        for (Pizzaer p : Menu.hentMenu()) {
            System.out.println(p);
            System.out.println("_________________________\n");
        }
    }
}
