public class Topping {

    public int pizzaId;
    public String navn;
    public int pris;

    public Topping(int pizzaId, String navn, int pris) {
        this.pizzaId = pizzaId;
        this.navn = navn;
        this.pris = pris;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public String getNavn() {
        return navn;
    }

    public int getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "Pizza Nr" + pizzaId + "Navn" + navn + "Pris" + pris;
    }


}

