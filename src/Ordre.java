import java.util.ArrayList;
import java.util.List;

public class Ordre {
    private int ordrenr;
    private Kunde kunde;
    private List<Pizzaer> pizzaer;
    private int totalPris;

    public Ordre(int ordrenr, Kunde kunde, int totalPris) {
        this.ordrenr = ordrenr;
        this.kunde = kunde;
        this.pizzaer = new ArrayList<>();
        this.totalPris = totalPris;


    }

    private int getOrdrenr() {
        return ordrenr;
    }

    private Kunde getKunde() {
        return kunde;
    }

    private int getTotalPris() {
        return totalPris;
    }

    public void tilføjPizza(Pizzaer pizza) {
        pizzaer.add(pizza);
        totalPris += pizza.getPris();



    }
}
