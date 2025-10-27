import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bestillingsliste {
    private List<Ordre> aktiveOrdrer;
    private List<Ordre> afsluttedeOrdrer;

    public Bestillingsliste(){
        aktiveOrdrer = new ArrayList<>();
        afsluttedeOrdrer = new ArrayList<>();
    }

    //Tilføj ny ordre
    public void tilføjOrdre(Ordre ordre){
        aktiveOrdrer.add(ordre);
        System.out.println("Ordre #" + ordre.getOrdrenr() + " tilføjet");
    }

    //Marker ordre som færdig
    public void afslutOrdre(int ordrenr){
        Ordre fundet = null;
        for (Ordre o : aktiveOrdrer){
            if (o.getOrdrenr() == ordrenr){
                fundet = o;
                break;
            }
        }
        if (fundet != null){
            aktiveOrdrer.remove(fundet);
            afsluttedeOrdrer.add(fundet);
            System.out.println("Ordre #" + ordrenr + " afsluttet og gemt i statistik");
        } else{
            System.out.println("Ordre #" + ordrenr + " ikke fundet blandt aktive ordrer.");
        }
    }
    //Vis aktive ordrer
    public void visAktiveOrdre(){
        if (aktiveOrdrer.isEmpty()){
            System.out.println("Ingen aktive ordrer");
        } else{
            System.out.println("Aktive ordrer:");
            for (Ordre o : aktiveOrdrer){
                System.out.println("- Ordre #" + o.getOrdrenr() +
                        " (" + o.getKunde().navn + ") : " +
                        o.getTotalPris() + " kr" +
                        " | Afhentning kl. " +
                        o.getafhentningTid().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm")));
            }
        }
    }
    // (Valgfrit) Vis afsluttede ordrer
    public void visAfsluttedeOrdrer() {
        if (afsluttedeOrdrer.isEmpty()) {
            System.out.println("Ingen afsluttede ordrer");
        } else {
            System.out.println("Afsluttede ordrer:");
            for (Ordre o : afsluttedeOrdrer) {
                System.out.println("- Ordre #" + o.getOrdrenr() + " (" + o.getKunde().navn + ") : " + o.getTotalPris() + " kr");
            }
        }
    }
    // (Valgfrit) Vis afsluttede ordrer
    public void visAfsluttedeOrdrer() {
        if (afsluttedeOrdrer.isEmpty()) {
            System.out.println("Ingen afsluttede ordrer");
        } else {
            System.out.println("Afsluttede ordrer:");
            for (Ordre o : afsluttedeOrdrer) {
                System.out.println("- Ordre #" + o.getOrdrenr() + " (" + o.getKunde().navn + ") : " + o.getTotalPris() + " kr");
            }
        }
    }
}