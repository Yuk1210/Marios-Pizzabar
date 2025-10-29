import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordre {
    private int ordreNr;
    private Kunde kunde;
    private List<Pizzaer> pizzaer; //starter med en tom liste af pizzaer,
    private int totalPris;
    private LocalDateTime oprettetTid;  // Hvornår ordren blev lavet
    private LocalDateTime afsluttetTid; // Hvornår ordren blev afsluttet

    // Når der laves en ny ordre
    public Ordre(int ordreNr, Kunde kunde) {
        this.ordreNr = ordreNr;
        this.kunde = kunde;
        this.pizzaer = new ArrayList<>();
        this.totalPris = 0;
        this.oprettetTid = LocalDateTime.now(); // Gem tidspunkt for oprettelse
        this.afsluttetTid = null;               // Ikke afsluttet endnu
    }

    // Tilføj pizza til ordren
    public void tilføjPizza(Pizzaer pizza) {
        pizzaer.add(pizza);
    }

    // Get og set
    public int getOrdreNr() {
        return ordreNr;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public List<Pizzaer> getPizzaer() {
        return pizzaer;
    }

    public int getTotalPris() {
        return totalPris;
    }

    public void setTotalPris(int totalPris) {
        this.totalPris = totalPris;
    }

    public LocalDateTime getOprettetTid() {
        return oprettetTid;
    }

    public LocalDateTime getAfsluttetTid() {
        return afsluttetTid;
    }

    // Når ordren afsluttes
    public void afslutOrdre() {
        this.afsluttetTid = LocalDateTime.now();
        System.out.println("Ordre #" + ordreNr + " afsluttet kl. " + afsluttetTid);
    }
}
