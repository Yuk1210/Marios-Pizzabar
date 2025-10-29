import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Formål med persisten er at den gemmer dataen, når vi "Afslut program" i txt.fil
//Den gemmer ordreID(Navn+Nr) og selve bestillingen - pizzanavn, evt ekstra topping + totalpris
public class OrdrePersistens {
        public static void ordrePersistens(List<Ordre> ordreListe) {
            String ordreFile = "ordre.txt";

/* Filewriter tager en tekst og gør det til en fil
True betyder, tilføjer ny data under den gamle. Så intet slettes
Hvis vi skrev false, ville det overskrive. Altså den sletter tidliggere data.
 */
            try (FileWriter writer = new FileWriter(ordreFile, true)) {


// I dette loop, beder vi at køre alt igennem på ordre listen.
                for (Ordre ordre : ordreListe) {


// Dette er det første den skriver i txt.filen, og dette er Kundens ordre nr og navn.
                    writer.write(ordre.getOrdreNr() + "," + ordre.getKunde().getNavn());


// I dette loop, beder vi at køre alle pizzaer på ordre listen.
                    for (Pizzaer pizza : ordre.getPizzaer()) {


// Her beder vi om at skrive pizza's navn i txt filen.
                        writer.write("," + pizza.getNavn() );


// Her beder vi om Hvis pizzaen har toppings, tilføjes de med.
                        for (Topping topping : pizza.getToppings()){
                            writer.write("+" + topping.getNavn());
                        }
                    }

// Til slut beder vi den om at gemme totalpris for ordren og at den nye ordre skal gemmes på næste linje
                            writer.write("," + ordre.getTotalPris());
                            writer.write("\n");
                }

// Hvis noget går galt, printes fejl
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


/* Formålet med readOrdre er den læser filen "ordre.txt" og udskriver hver linje i konsollen,
     præcis som den er gemt.
     Denne version fortolker ikke data, den viser kun indhold.
     Dette er lavet klar, så det kan printes i konsollen, men vi benytter os det ikke ligenu. (snak med gruppen)
     */

    public static void readOrdre() {
        String ordreFile = "ordre.txt";
        List<Ordre> ordreList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ordreFile))) {
            String line;

// Læser filen linje for linje
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        }
        // Hvis filen ikke kan læses, vises fejl i konsollen
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


