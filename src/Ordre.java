import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordre {
    private int ordrenr;
    private boolean faerdig;
    private Kunde kunde;
    private List<Pizzaer> pizzaer;
    private int totalPris;
    private LocalDateTime tidspunkt;

    public Ordre(int ordrenr, Kunde kunde) { //vi vælger int ordrenr og Kunde kunde, fordi det de vigtigste
        //parametre vi ville vide.
        this.ordrenr = ordrenr;
        this.kunde = kunde;
        this.pizzaer = new ArrayList<>();//den går igennem vores lise at pizzaer.
        this.faerdig = false;//den starter false, hvilket betyder ordren stadig er igang med at blive lavet.
        this.tidspunkt = LocalDateTime.now(); //den giver os det præcise tidspunkt.
    }

    // GETTERS (til at hente data)
    public int getOrdrenr() {
        return ordrenr;
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

    public LocalDateTime getTidspunkt() {
        return tidspunkt;
    }

    public boolean isFaerdig() { //her starter den false, når den er lavet bliver den true.
        return faerdig;
    }


    public void addPizza(Pizzaer pizza) { //betyder, at metoden modtager et objekt af typen Pizzaer (altså en pizza, som du har defineret i en anden klasse).
        pizzaer.add(pizza);
        totalPris += pizza.pris;
    }

    public void setFaerdig(boolean faerdig) {
        this.faerdig = faerdig;
    }

    @Override
    public String toString() {
        return "Ordre #" + ordrenr + " (" + tidspunkt.toLocalTime().withNano(0) + ")\n" +
                "Kunde: " + kunde.navn + "\n" +
                "Antal pizzaer: " + pizzaer.size() + "\n" +
                "Total pris: " + totalPris + " kr\n";
    }
}
