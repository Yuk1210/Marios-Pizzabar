import java.util.ArrayList;
import java.util.List;

public class Bestillingsliste {
    private List<Ordre> aktiveOrdrer;

    public Bestillingsliste() { //dette er konstruktor, Når du laver en ny bestillingsliste, starter den tom.
        aktiveOrdrer = new ArrayList<>();
    }

    // Tilføj en ordre til listen
    public void tilføjOrdre(Ordre ordre) {
        aktiveOrdrer.add(ordre);
    }

    // Vis alle aktive ordrer
    public void visAktiveOrdre() { //aktiveOrdrer er en liste (ArrayList) med alle igangværende ordrer.
        if (aktiveOrdrer.isEmpty()) { //Metoden isEmpty() returnerer true, hvis listen er tom.
            System.out.println("Ingen aktive ordrer.");
            return;
        }

        System.out.println("==== AKTIVE ORDRER ====");
        for (Ordre ordre : aktiveOrdrer) { //Dette er et for-each loop, som går igennem alle Ordre-objekter i listen aktiveOrdrer.
            //For hver Ordre i listen, gemmes den midlertidigt i variablen ordre, så du kan hente dens informationer.
            System.out.println("Ordre #" + ordre.getOrdreNr() +
                    " | Kunde: " + ordre.getKunde().getNavn() +
                    " | Total: " + ordre.getTotalPris() + " kr" +
                    " | Bestilt: " + formatTid(ordre.getOprettetTid()));
        }
        System.out.println("=======================");
    }

    // Hjælpe-metode til at vise tid pænt (uden DateTimeFormatter)
    private String formatTid(java.time.LocalDateTime tid) { //Metoden tager én parameter, som er et tidspunkt (LocalDateTime) fra Java’s tids-API.
        return tid.getDayOfMonth() + "-" + tid.getMonthValue() + "-" + tid.getYear() +
                " " + tid.getHour() + ":" + (tid.getMinute() < 10 ? "0" + tid.getMinute() : tid.getMinute());
        //Dette er en kort “hvis-sætning”:
        //Hvis minutterne er mindre end 10, fx 5,
        //så laver den "0" + 5 → "05"
        //Ellers bruger den bare tallet, fx 15 → "15"
        //Dette sikrer, at minutter altid vises med to cifre, som man normalt ser på ure.

    }

    // Afslut en ordre
    public void afslutOrdre(int ordreNr) { //Den tager ét argument: et ordrenummer som man vil afslutte.
        Ordre ordre = findOrdre(ordreNr);
        if (ordre != null) {
            aktiveOrdrer.remove(ordre);
            ordre.afslutOrdre();
        } else {
            System.out.println("Ordre #" + ordreNr + " findes ikke.");

            //ordre != null → betyder: “Hvis vi faktisk fandt en ordre med det nummer”.
            // Hvis ordren ikke findes (ordre == null), printes en besked:
        }
    }

    // Find en ordre ud fra nummer
    public Ordre findOrdre(int ordreNr) {
        for (Ordre ordre : aktiveOrdrer) { //Går igennem listen aktiveOrdrer.
            //ordre er en variabel, der repræsenterer én ordre ad gangen i listen.
            if (ordre.getOrdreNr() == ordreNr) {
                return ordre;

                //ordre.getOrdreNr() → Henter ordrenummeret fra den aktuelle ordre.
                //== ordreNr → Sammenligner med det nummer, vi leder efter.
                //Hvis de er ens, har vi fundet den ordre, vi leder efter.
                //Når return udføres, stopper metoden med det samme – vi behøver ikke tjekke resten af listen.
            }
        }
        return null;
        //Hvis løkken gennemgår hele listen uden at finde noget, returneres null.
    }
}
