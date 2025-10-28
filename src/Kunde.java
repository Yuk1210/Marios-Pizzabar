import java.util.Random;

public class Kunde {
    // En liste med mulige navne, som vi kan vælge imellem
    private static final String[] NAVNE = {
            "Anders", "Maria", "Jonas", "Laura", "Peter",
            "Emma", "Mikkel", "Sofie", "Thomas", "Ida"
    };

    private String navn;
    private String ordrenr;

    // Constructor: bruges når vi laver en ny kunde
    public Kunde(String navn, String ordrenr) {
        this.navn = navn;
        this.ordrenr = ordrenr;
    }

    // Hent kundens navn
    public String getNavn() {
        return navn;
    }

    // Sæt kundens navn
    public void setNavn(String navn) {
        this.navn = navn;
    }

    // Hent ordrenummer (hvis du vil bruge det)
    public String getOrdrenr() {
        return ordrenr;
    }

    // Sæt ordrenummer
    public void setOrdrenr(String ordrenr) {
        this.ordrenr = ordrenr;
    }

    // Metode til at vælge et tilfældigt navn fra listen
    public static String randomNavn() {
        Random random = new Random();
        return NAVNE[random.nextInt(NAVNE.length)];
    }
}

