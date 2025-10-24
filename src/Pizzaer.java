public class Pizzaer {
    private int id;
    private String navn;
    private String ingredienser;
    private int pris;

    public Pizzaer(int id, String navn, String ingredienser, int pris) {
        this.id = id;
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.pris = pris;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public String getIngredienser() {
        return ingredienser;
    }

    public int getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "Nr: " + id + ", Navn: " + navn + "\n"
                + ingredienser + "\n"
                + "Pris: " + pris + "Kr\n";
    }
}