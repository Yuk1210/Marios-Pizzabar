public class Pizzaer {
    private int id;
    private String navn;
    private String ingredienser;
    private int pris;

    public Pizzaer (int id, String navn, String ingredienser, int pris) {
        this.id = id;
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.pris = pris;
    }


    @Override
    public String toString() {
        return "Nr: " + id + ", Navn: " + navn + "\n"
                + ingredienser + "\n"
                + "Pris: " + pris + "Kr\n";
    }
    public int getPris(){
        return pris;
    }
}