public class Pizzaer {
    public int id;
    public String navn;
    public String ingredienser;
    public int pris;

    public Pizzaer (int id, String navn, String ingredienser, int pris) {
        this.id = id;
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.pris = pris;
    }


    @Override
    public String toString() {
        return id + navn + ingredienser + pris;
    }
}