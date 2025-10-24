import java.util.ArrayList;
import java.util.List;

public class Ordre{
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

    //Getter
    public int getOrdrenr() {
        return ordrenr;}
    public Kunde getKunde() {
        return kunde;}
    public List<Pizzaer> getPizzaer() {
        return pizzaer;}
    public int getTotalPris() {
        return totalPris;}

    public void tilføjPizza(Pizzaer pizza) {
        pizzaer.add(pizza);
        totalPris += pizza.getPris();
    }
}