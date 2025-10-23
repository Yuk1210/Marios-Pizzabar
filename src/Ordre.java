import java.util.ArrayList;
import java.util.List;

public class Ordre {
    public int ordrenr;
    public boolean feardig;
    public Kunde kunde;
    public List<Pizzaer> pizzaer;
    public int totalPris;

    public Ordre(int ordrenr, Kunde kunde) {
        this.ordrenr = ordrenr;
        this.kunde = kunde;
        this.pizzaer = new ArrayList<>();
        this.feardig = false;
    }

    private int getOrdrenr() {
        return ordrenr;
    }

    private kunde getKunde() {
        return kunde;
    }

    private int getTotalPris() {
        return totalPris;
    }
}
